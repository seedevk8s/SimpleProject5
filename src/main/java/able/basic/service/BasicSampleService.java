package able.basic.service;

import java.util.List;

import able.basic.vo.BasicSampleVO;


/**
 *
 * @ClassName   : BasicSampleService.java
 * @Description : 기본 crud 를 테스트할수 있는 샘플 클래스
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
public interface BasicSampleService {

    /**
     * 게시글 등록
     * @param vo
     * @return
     * @throws Exception
     */
    void insertSample(BasicSampleVO vo) throws Exception;
    
    /**
     * 게시글 수정
     * @param vo
     * @throws Exception
     */
    void updateSample(BasicSampleVO vo) throws Exception;
    
    /**
     * 게시글 삭제
     * @param seq
     * @throws Exception
     */
    void deleteSample(String seq) throws Exception;
    
    /**
     * 게시글 상세 조회
     * @param seq
     * @return
     * @throws Exception
     */
    BasicSampleVO selectSample(String seq) throws Exception;
    
    /**
     * 목록 조회
     * @param vo
     * @return
     * @throws Exception
     */
    List<BasicSampleVO> selectSampleList(BasicSampleVO vo) throws Exception;
    
    /**
     * 조회수 Count (+1)
     * @param seq
     * @throws Exception
     */
    void updateSampleViewCount(String seq) throws Exception;

}

