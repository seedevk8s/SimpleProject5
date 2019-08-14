package able.newboard.service.dao;

import java.util.List;

import able.com.mybatis.Mapper;
import able.newboard.vo.NewBoardSampleFileVO;
import able.newboard.vo.NewBoardSampleVO;

/**
 * <pre>
 * Statements
 * </pre>
 *
 * @ClassName   : NewBoardSampleMDAO.java
 * @Description : 게시판 샘플 클래스
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

@Mapper("newBoardSampleMDAO")
public interface NewBoardSampleMDAO {

    /**
     * 게시글 등록
     * @param vo
     * @return
     * @throws Exception
     */
    void insertSample(NewBoardSampleVO vo) throws Exception;
    
    /**
     * 게시글 수정
     * @param vo
     * @throws Exception
     */
    void updateSample(NewBoardSampleVO vo) throws Exception;
    
    /**
     * 게시글 삭제
     * @param seq
     * @throws Exception
     */
    void deleteSample(String id) throws Exception;
    
    /**
     * 게시글 상세 조회
     * @param seq
     * @return
     * @throws Exception
     */
    NewBoardSampleVO selectSample(String id) throws Exception;
    
    /**
     * 목록 조회
     * @param vo
     * @return
     * @throws Exception
     */
    List<NewBoardSampleVO> selectSampleList(NewBoardSampleVO vo) throws Exception;
    
    /**
     * 첨부파일 다운로드 (선택된 첨부파일에 대한 정보 가져오기)
     * @param id
     * @return
     * @throws Exception
     */
    NewBoardSampleFileVO selectFileVOByKey(String id) throws Exception;
    
    /**
     * 첨부파일 삭제 (선택된 첨부파일 삭제)
     * @param fileId
     * @return
     */
    int deleteFileVOByKey(String fileId);
    
    /**
     * 첨부파일 등록
     * @param vo
     * @throws Exception
     */
    void insertFile(NewBoardSampleFileVO vo) throws Exception;
    
    /**
     * 게시글 ID 생성 (ART_ID)
     * @return
     * @throws Exception
     */
    String selectMaxArticleId() throws Exception;
    
    /**
     * 첨부파일 리스트
     * @param artId
     * @return
     * @throws Exception
     */
    List<NewBoardSampleFileVO> selectFileVOList(String artId) throws Exception;
    
    /**
     * Pagination을 위한 게시글 총 갯수
     * @param vo
     * @return
     * @throws Exception
     */
    int selectSampleListCount(NewBoardSampleVO vo) throws Exception;

    /**
     * 파일 ID 조회
     *
     * @param newBoardSampleVO
     * @return List<BoardSampleFileVO>
     * @throws Exception
     */
    List<NewBoardSampleFileVO> selectFileId(NewBoardSampleVO newBoardSampleVO) throws Exception;     
}

































