package able.newboard.service.impl;

import java.util.List;

import javax.annotation.Resource;

import able.board.vo.BoardSampleFileVO;
import able.com.service.HService;
import able.newboard.service.NewBoardSampleService;
import able.newboard.service.dao.NewBoardSampleMDAO;
import able.newboard.vo.NewBoardSampleFileVO;
import able.newboard.vo.NewBoardSampleVO;

import org.springframework.stereotype.Service;

/**
 * <pre>
 * Statements
 * </pre>
 *
 * @ClassName   : NewBoardSampleServiceImpl.java
 * @Description : 게시판 샘플 서비스
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

@Service("newBoardSampleService")
public class NewBoardSampleServiceImpl extends HService implements NewBoardSampleService {
    
    @Resource(name = "newBoardSampleMDAO")
    private NewBoardSampleMDAO newBoardSampleMDAO;    

    
    @Override
    public void insertSample(NewBoardSampleVO vo) throws Exception {

        vo.setArtId(newBoardSampleMDAO.selectMaxArticleId());

        //게시글
        newBoardSampleMDAO.insertSample(vo);
        
        if(vo.getFileList() != null){
            int fileList = vo.getFileList().size();     
            
            for(int i=0; i<fileList; i++){
                NewBoardSampleVO bsfv = new NewBoardSampleVO();
                bsfv.setArtId(vo.getArtId());                             
/*                
                bsfv.setFileId(vo.getFileList().get(i).getFileId());
                bsfv.setFileSize(vo.getFileList().get(i).getFileSize());
                bsfv.setFolderPath(vo.getFileList().get(i).getFolderPath());
                bsfv.setOriginalFileName(vo.getFileList().get(i).getOriginalFileName());
                bsfv.setRegDate(vo.getFileList().get(i).getRegDate());
                bsfv.setStoredFileName(vo.getFileList().get(i).getStoredFileName());
                
                insertFile(bsfv);*/
            }
        }        
        
    }


    @Override
    public void updateSample(NewBoardSampleVO vo) throws Exception {

        newBoardSampleMDAO.updateSample(vo); 
        
        if(vo.getFileList() != null){
            int fileList = vo.getFileList().size();     
            
            for(int i=0; i<fileList; i++){
                BoardSampleFileVO bsfv = new BoardSampleFileVO();
                bsfv.setArtId(vo.getArtId());
/*                
                bsfv.setFileId(vo.getFileList().get(i).getFileId());
                bsfv.setFileSize(vo.getFileList().get(i).getFileSize());
                bsfv.setFolderPath(vo.getFileList().get(i).getFolderPath());
                bsfv.setOriginalFileName(vo.getFileList().get(i).getOriginalFileName());
                bsfv.setRegDate(vo.getFileList().get(i).getRegDate());
                bsfv.setStoredFileName(vo.getFileList().get(i).getStoredFileName());
                
                insertFile(bsfv);*/
            }
        }        
        
    }

    
    @Override
    public void deleteSample(String id) throws Exception {
        newBoardSampleMDAO.deleteSample(id);
        
    }

    
    @Override
    public NewBoardSampleVO selectSample(String id) throws Exception {
        return newBoardSampleMDAO.selectSample(id);
    }


    @Override
    public List<NewBoardSampleVO> selectSampleList(NewBoardSampleVO vo) throws Exception {
        return newBoardSampleMDAO.selectSampleList(vo); 
    }


    @Override
    public List<NewBoardSampleFileVO> selectFileVOList(String artId) throws Exception {
        return newBoardSampleMDAO.selectFileVOList(artId);
    }


    @Override
    public NewBoardSampleFileVO selectFileVOByKey(String id) throws Exception {
        return newBoardSampleMDAO.selectFileVOByKey(id);
    }


    @Override
    public int deleteFileVOByKey(String fileId) {
        return newBoardSampleMDAO.deleteFileVOByKey(fileId);
    }


    @Override
    public void insertFile(NewBoardSampleFileVO vo) throws Exception {
        newBoardSampleMDAO.insertFile(vo);
        
    }


    @Override
    public String selectMaxArticleId() throws Exception {
        return newBoardSampleMDAO.selectMaxArticleId();
    }


    @Override
    public int selectSampleListCount(NewBoardSampleVO vo) throws Exception {
        return newBoardSampleMDAO.selectSampleListCount(vo);
    }


    @Override
    public List<NewBoardSampleFileVO> selectFileId(NewBoardSampleVO newBoardSampleVO) throws Exception {
        return newBoardSampleMDAO.selectFileId(newBoardSampleVO);
    }

}



































