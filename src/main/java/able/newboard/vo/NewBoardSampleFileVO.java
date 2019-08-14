package able.newboard.vo;

import able.com.service.file.FileVO;

/**
 * <pre>
 * Statements
 * </pre>
 *
 * @ClassName   : NewBoardSampleFileVO.java
 * @Description : 게시판 파일 정보
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

public class NewBoardSampleFileVO extends FileVO{
    /** 게시글 ID */
    private String artId;

    public String getArtId() {
        return artId;
    }

    public void setArtId(String artId) {
        this.artId = artId;
    }
}
