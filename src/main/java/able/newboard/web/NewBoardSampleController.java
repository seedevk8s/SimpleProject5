package able.newboard.web;

import java.util.List;

import javax.annotation.Resource;

import able.board.vo.BoardSampleVO;
import able.com.service.file.FileUploadService;
import able.com.web.HController;
import able.com.web.view.PagingInfo;
import able.newboard.service.NewBoardSampleService;
import able.newboard.vo.NewBoardSampleFileVO;
import able.newboard.vo.NewBoardSampleVO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
    
    
    
    
    
    
    
    
    
    
    
    
    
}






























