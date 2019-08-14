package able.newboard.web;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import able.board.vo.BoardSampleFileVO;
import able.board.vo.BoardSampleVO;
import able.com.service.file.FileUploadService;
import able.com.service.file.FileVO;
import able.com.util.sim.FileTool;
import able.com.web.HController;
import able.com.web.view.PagingInfo;
import able.newboard.service.NewBoardSampleService;
import able.newboard.vo.NewBoardSampleFileVO;
import able.newboard.vo.NewBoardSampleVO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <pre>
 * Statements
 * </pre>
 *
 * @ClassName   : NewBoardSampleController.java
 * @Description : 게시판 샘플 컨트롤로
 * @author hojin
 * @since 2019. 8. 13.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 *     since          author              description
 *  ===========    =============    ===========================
 *  2019. 8. 13.     hojin     	최초 생성
 * </pre>
 */

@Controller
public class NewBoardSampleController extends HController{

    @Resource(name = "newBoardSampleService")
    private NewBoardSampleService newBoardSampleService;
    
    /**
     * 파일 업로드 서비스
     */
    @Resource(name = "fileUploadService")
    FileUploadService fileUploadService;
    
    /**
     * 게시글의 목록을 조회한다.
     * 
     * @param NewBoardSampleVO
     * @param model
     * @return
     * @throws Exception
     */
    
    @RequestMapping(value = "/cmm/newboard/selectItemList.do")
    public String selectItemList(@ModelAttribute("newBoardSampleVO") NewBoardSampleVO newBoardSampleVO, Model model) 
        throws Exception {
        
        
 
        
        if (null == newBoardSampleVO.getCurrPage() || newBoardSampleVO.getCurrPage().equals("")) {
            newBoardSampleVO.setCurrPage("1");
        }
        int currPage = Integer.parseInt(newBoardSampleVO.getCurrPage());       
             
        newBoardSampleVO.setLimit("10");
        newBoardSampleVO.setOffset(String.valueOf(10 * (currPage - 1)));     
        
        List<NewBoardSampleVO> sampleList = newBoardSampleService.selectSampleList(newBoardSampleVO);
        
        // 페이징 정보
        PagingInfo pagingInfo = new PagingInfo();
        int listCount = newBoardSampleService.selectSampleListCount(newBoardSampleVO);
        pagingInfo.setTotalRecordCount(listCount);
        int pageUnit = propertiesService.getInt("pageUnit");
        pagingInfo.setRecordCountPerPage(pageUnit);
        int pageSize = propertiesService.getInt("pageSize");
        pagingInfo.setPageSize(pageSize);
        pagingInfo.setCurrentPageNo(Integer.parseInt(newBoardSampleVO.getCurrPage()));

        model.addAttribute("resultList", sampleList);
        model.addAttribute("page", pagingInfo);

        return "newboard/newboardSampleList";
        
    }
    
    
    
    /**
     * 게시글 상세 조회 화면
     * 
     * @param boardSampleVO
     * @param id
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/cmm/newboard/selectItemById.do")
    public String selectItemById(@ModelAttribute NewBoardSampleVO newBoardSampleVO, @RequestParam("selectedId") String id,
            Model model) throws Exception {
        // 첨부파일 리스트
        model.addAttribute("fileList", selectFileList(id));
        // 글 상세내용
        model.addAttribute("newBoardSampleVO", selectItem(id));
        return "newboard/newboardSampleDetailView";
    }    
    
    
    /**
     * (공통함수) 첨부파일 리스트 가져오기
     * 
     * @param id
     * @return
     * @throws Exception
     */
    public List<NewBoardSampleFileVO> selectFileList(String id) throws Exception {
        return newBoardSampleService.selectFileVOList(id);
    }    
    
    
    /**
     * (공통함수) 게시글 상세 내용 가져오기
     * 
     * @param id
     * @return
     * @throws Exception
     */
    public NewBoardSampleVO selectItem(String id) throws Exception {
        return newBoardSampleService.selectSample(id);
    }    
    
    
    /**
     * 게시글 등록 화면
     * 
     * @param boardSampleVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/cmm/newboard/insertItemForm.do", method = RequestMethod.GET)
    public String insertItemForm(@ModelAttribute NewBoardSampleVO newBoardSampleVO, Model model) throws Exception {
        return "newboard/newboardSampleRegisterForm";
    }    
    
    
    /**
     * 게시글 등록
     * 유효성 검사 후 조건에 맞지 않으면 form으로 이동하고, 조건에 맞으면 INSERT를 하고 게시글 목록 화면으로 이동한다.
     * 첨부 파일이 있는지 확인 하고 첨부파일이 있는 경우 첨부파일 업로드를 한다.
     * 
     * @param boardSampleVO
     * @param result
     * @param model
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/cmm/newboard/insertItem.do", method = RequestMethod.POST)
    public String insertItem(@ModelAttribute @Valid NewBoardSampleVO newBoardSampleVO, BindingResult result, Model model,
            HttpServletRequest request) throws Exception {

        // form 유효성 검사
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError e : list) {
                logger.debug("ObjectError : " + e);
            }
            return "newboard/boardSampleRegisterForm";
        }

        // 첨부파일 여부 확인, 첨부파일이 존재하면 업로드
        checkFileUpload(request, newBoardSampleVO);

        // 게시글 DB 저장
        newBoardSampleService.insertSample(newBoardSampleVO);

        return "forward:/cmm/newboard/selectItemList.do";
    }    
    
    
    /**
     * 첨부파일 여부 체크
     * 
     * @param request
     * @param boardSampleVO
     * @throws Exception
     */
    public void checkFileUpload(HttpServletRequest request, NewBoardSampleVO newBoardSampleVO) throws Exception {
        // 파일 업로드
        List<FileVO> uploadFileList = fileUploadService.upload(request);

        if (uploadFileList != null) {

            List<NewBoardSampleFileVO> bsfvList = new ArrayList<NewBoardSampleFileVO>();
            int fileList = uploadFileList.size();
            for (int i = 0; i < fileList; i++) {
                NewBoardSampleFileVO fv = new NewBoardSampleFileVO();
/*                
                fv.setFileId(uploadFileList.get(i).getFileId());
                fv.setFileSize(uploadFileList.get(i).getFileSize());
                fv.setFolderPath(uploadFileList.get(i).getFolderPath());
                fv.setRegDate(uploadFileList.get(i).getRegDate());
                fv.setOriginalFileName(uploadFileList.get(i).getOriginalFileName());
                fv.setStoredFileName(uploadFileList.get(i).getStoredFileName());
                bsfvList.add(fv);*/
            }
            newBoardSampleVO.setFileList(bsfvList);
        }
    }   
    
    
    /**
     * 게시글 수정 화면
     * 
     * @param boardSampleVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/cmm/newboard/updateItemForm.do")
    public String updateItemForm(@ModelAttribute NewBoardSampleVO newBoardSampleVO, Model model) throws Exception {
        String id = newBoardSampleVO.getArtId();
        model.addAttribute("newBoardSampleVO", selectItem(id));
        model.addAttribute("fileList", selectFileList(id));
        return "newboard/newboardSampleModifyForm";
    }   
    
    
    /**
     * 게시글 수정
     * 유효성 검사 후 조건에 맞지 않으면 form으로 이동하고, 조건에 맞으면 UPDATE를 하고 게시글 수정 화면으로 이동한다.
     * 첨부 파일이 있는지 확인 하고 첨부파일이 있는 경우 첨부파일 업로드를 한다.
     * 
     * @param request
     * @param boardSampleVO
     * @param result
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/cmm/newboard/updateItem.do", method = RequestMethod.POST)
    public String updateItem(HttpServletRequest request, @ModelAttribute @Valid NewBoardSampleVO newBoardSampleVO,
            BindingResult result, Model model) throws Exception {

        // form 유효성 검사
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError e : list) {
                logger.debug("ObjectError : " + e);
            }
            return "newboard/newboardSampleModifyForm";
        }

        // 파일 업로드
        checkFileUpload(request, newBoardSampleVO);

        // 게시글 업데이트
        newBoardSampleService.updateSample(newBoardSampleVO);

        String id = newBoardSampleVO.getArtId();
        model.addAttribute("result", selectItem(id));
        model.addAttribute("fileList", selectFileList(id));
        return "newboard/newboardSampleDetailView";
    }    
    
    
    
    /**
     * 게시글 삭제
     * 
     * @param newBoardSampleVO
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "/cmm/newboard/deleteItem.do")
    public String deleteItem(@ModelAttribute NewBoardSampleVO newBoardSampleVO) throws Exception {
        List<NewBoardSampleFileVO> fileList = newBoardSampleService.selectFileId(newBoardSampleVO);
        String filePath = "";
        for(NewBoardSampleFileVO vo : fileList) {
            filePath = vo.getFolderPath() + File.separator + vo.getStoredFileName();
            // 파일 삭제
            FileTool.deleteFile(filePath);
         // DB 삭제
            newBoardSampleService.deleteFileVOByKey(vo.getFileId());
        }
        
        newBoardSampleService.deleteSample(newBoardSampleVO.getArtId());
        return "forward:/cmm/newboard/selectItemList.do";
    }    
    
}






























