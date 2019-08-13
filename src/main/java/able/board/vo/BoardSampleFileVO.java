package able.board.vo;

import able.com.service.file.FileVO;

/**
 *
 * @ClassName   : BoardSampleFileVO.java
 * @Description : 게시판 파일 정보
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
public class BoardSampleFileVO extends FileVO{
    /** 게시글 ID */
    private String artId;

    public String getArtId() {
        return artId;
    }

    public void setArtId(String artId) {
        this.artId = artId;
    }
}
