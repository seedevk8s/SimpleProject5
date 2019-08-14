package able.newboard.vo;

import java.util.List;

import able.board.vo.BoardSampleFileVO;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * <pre>
 * Statements
 * </pre>
 *
 * @ClassName   : NewBoardSampleVO.java
 * @Description : 게시판 정보
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

public class NewBoardSampleVO {

    /** 게시글 ID */
    private String artId;

    /** 게시글 분류 */
    private String artCategory;

    /** 게시글 제목 */
    @NotEmpty(message = "{errors.required}")
    private String artSubject;

    /** 게시글 내용 */
    @NotEmpty(message = "{errors.required}")
    private String artContent;

    /** 게시자 */
    @NotEmpty(message = "{errors.required}")
    private String regUser;

    /** 게시일 */
    private String regDate;

    /** 첨부파일 유무 */
    private String attachYn;

    /** 검색Keyword */
    private String searchKeyword;

    /** 검색조건 */
    private String searchCondition;

    /** offset */
    private String offset;

    /** limit */
    private String limit;

    /** 현재 페이지 */
    private String currPage;
    
    private List<NewBoardSampleFileVO> fileList;
    
    

    /**
     * @return the fileList
     */
    public List<NewBoardSampleFileVO> getFileList() {
        return fileList;
    }

    /**
     * @param fileList the fileList to set
     */
    public void setFileList(List<NewBoardSampleFileVO> fileList) {
        this.fileList = fileList;
    }

    /**
     * @return the artId
     */
    public String getArtId() {
        return artId;
    }

    /**
     * @param artId the artId to set
     */
    public void setArtId(String artId) {
        this.artId = artId;
    }

    /**
     * @return the artCategory
     */
    public String getArtCategory() {
        return artCategory;
    }

    /**
     * @param artCategory the artCategory to set
     */
    public void setArtCategory(String artCategory) {
        this.artCategory = artCategory;
    }

    /**
     * @return the artSubject
     */
    public String getArtSubject() {
        return artSubject;
    }

    /**
     * @param artSubject the artSubject to set
     */
    public void setArtSubject(String artSubject) {
        this.artSubject = artSubject;
    }

    /**
     * @return the artContent
     */
    public String getArtContent() {
        return artContent;
    }

    /**
     * @param artContent the artContent to set
     */
    public void setArtContent(String artContent) {
        this.artContent = artContent;
    }

    /**
     * @return the regUser
     */
    public String getRegUser() {
        return regUser;
    }

    /**
     * @param regUser the regUser to set
     */
    public void setRegUser(String regUser) {
        this.regUser = regUser;
    }

    /**
     * @return the regDate
     */
    public String getRegDate() {
        return regDate;
    }

    /**
     * @param regDate the regDate to set
     */
    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    /**
     * @return the attachYn
     */
    public String getAttachYn() {
        return attachYn;
    }

    /**
     * @param attachYn the attachYn to set
     */
    public void setAttachYn(String attachYn) {
        this.attachYn = attachYn;
    }

    /**
     * @return the searchKeyword
     */
    public String getSearchKeyword() {
        return searchKeyword;
    }

    /**
     * @param searchKeyword the searchKeyword to set
     */
    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    /**
     * @return the searchCondition
     */
    public String getSearchCondition() {
        return searchCondition;
    }

    /**
     * @param searchCondition the searchCondition to set
     */
    public void setSearchCondition(String searchCondition) {
        this.searchCondition = searchCondition;
    }

    /**
     * @return the offset
     */
    public String getOffset() {
        return offset;
    }

    /**
     * @param offset the offset to set
     */
    public void setOffset(String offset) {
        this.offset = offset;
    }

    /**
     * @return the limit
     */
    public String getLimit() {
        return limit;
    }

    /**
     * @param limit the limit to set
     */
    public void setLimit(String limit) {
        this.limit = limit;
    }

    /**
     * @return the currPage
     */
    public String getCurrPage() {
        return currPage;
    }

    /**
     * @param currPage the currPage to set
     */
    public void setCurrPage(String currPage) {
        this.currPage = currPage;
    }
    
    
}




































