package able.board.service.impl;

import java.util.List;

import javax.annotation.Resource;

import able.board.service.BoardSampleService;
import able.board.service.dao.BoardSampleMDAO;
import able.board.vo.BoardSampleFileVO;
import able.board.vo.BoardSampleVO;
import able.com.service.HService;

import org.springframework.stereotype.Service;

/**
 *
 * @ClassName   : BoardSampleServiceImpl.java
 * @Description : 게시판 샘플 서비스
 * @author ADM기술팀
 * @since 2016. 7. 1.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 *     since          author              description
 *  ===========    =============    ===========================
 *  2016. 7. 1.      ADM기술팀     	최초 생성
 * </pre>
 */
@Service("boardSampleService")
public class BoardSampleServiceImpl extends HService implements BoardSampleService {
	
	@Resource(name = "boardSampleMDAO")
	private BoardSampleMDAO boardSampleMDAO;
	
	@Override
	public void insertSample(BoardSampleVO vo) throws Exception {
		
		vo.setArtId(boardSampleMDAO.selectMaxArticleId());

		//게시글
		boardSampleMDAO.insertSample(vo);
		
		if(vo.getFileList() != null){
			int fileList = vo.getFileList().size();		
			
			for(int i=0; i<fileList; i++){
				BoardSampleFileVO bsfv = new BoardSampleFileVO();
				bsfv.setArtId(vo.getArtId());
				bsfv.setFileId(vo.getFileList().get(i).getFileId());
				bsfv.setFileSize(vo.getFileList().get(i).getFileSize());
				bsfv.setFolderPath(vo.getFileList().get(i).getFolderPath());
				bsfv.setOriginalFileName(vo.getFileList().get(i).getOriginalFileName());
				bsfv.setRegDate(vo.getFileList().get(i).getRegDate());
				bsfv.setStoredFileName(vo.getFileList().get(i).getStoredFileName());
				
				insertFile(bsfv);
			}
		}
	}

	@Override
	public void updateSample(BoardSampleVO vo) throws Exception {
		boardSampleMDAO.updateSample(vo); 
		
		if(vo.getFileList() != null){
			int fileList = vo.getFileList().size();		
			
			for(int i=0; i<fileList; i++){
				BoardSampleFileVO bsfv = new BoardSampleFileVO();
				bsfv.setArtId(vo.getArtId());
				bsfv.setFileId(vo.getFileList().get(i).getFileId());
				bsfv.setFileSize(vo.getFileList().get(i).getFileSize());
				bsfv.setFolderPath(vo.getFileList().get(i).getFolderPath());
				bsfv.setOriginalFileName(vo.getFileList().get(i).getOriginalFileName());
				bsfv.setRegDate(vo.getFileList().get(i).getRegDate());
				bsfv.setStoredFileName(vo.getFileList().get(i).getStoredFileName());
				
				insertFile(bsfv);
			}
		}
	}

	@Override
	public void deleteSample(String id) throws Exception {
		boardSampleMDAO.deleteSample(id);
	}

	@Override
	public BoardSampleVO selectSample(String id) throws Exception {
		return boardSampleMDAO.selectSample(id);
	}

	@Override
	public List<BoardSampleVO> selectSampleList(BoardSampleVO vo) throws Exception {
		return boardSampleMDAO.selectSampleList(vo); 
	}

	@Override
	public BoardSampleFileVO selectFileVOByKey(String id) throws Exception {
		return boardSampleMDAO.selectFileVOByKey(id);
	}
	
	@Override
	public int deleteFileVOByKey(String fileId) {
		return boardSampleMDAO.deleteFileVOByKey(fileId);
	}

	@Override
	public void insertFile(BoardSampleFileVO vo) throws Exception {
		boardSampleMDAO.insertFile(vo);
	}

	@Override
	public String selectMaxArticleId() throws Exception {
		return boardSampleMDAO.selectMaxArticleId();
	}

	@Override
	public List<BoardSampleFileVO> selectFileVOList(String artId) throws Exception {
		return boardSampleMDAO.selectFileVOList(artId);
	}

	@Override
	public int selectSampleListCount(BoardSampleVO vo) throws Exception {
		return boardSampleMDAO.selectSampleListCount(vo);
	}

    /*
     * @see able.board.service.BoardSampleService#selectFileId(able.board.vo.BoardSampleVO)
     */
    @Override
    public List<BoardSampleFileVO> selectFileId(BoardSampleVO boardSampleVO) throws Exception {
        return boardSampleMDAO.selectFileId(boardSampleVO);
    }
	
	
}
