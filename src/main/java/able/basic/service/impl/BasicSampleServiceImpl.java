package able.basic.service.impl;

import java.util.List;

import javax.annotation.Resource;

import able.basic.service.BasicSampleService;
import able.basic.service.dao.BasicSampleMDAO;
import able.basic.vo.BasicSampleVO;
import able.com.service.HService;

import org.springframework.stereotype.Service;

/**
 *
 * @ClassName   : BasicSampleServiceImpl.java
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
@Service("basicSampleService")
public class BasicSampleServiceImpl extends HService implements BasicSampleService {
	
	@Resource(name = "basicSampleMDAO")
	private BasicSampleMDAO basicSampleMDAO;
	
	@Override
	public void insertSample(BasicSampleVO vo) throws Exception {
		basicSampleMDAO.insertSample(vo);
	}

	@Override
	public void updateSample(BasicSampleVO vo) throws Exception {
		basicSampleMDAO.updateSample(vo); 
	}

	@Override
	public void deleteSample(String seq) throws Exception {
		basicSampleMDAO.deleteSample(seq);
	}

	@Override
	public BasicSampleVO selectSample(String seq) throws Exception {
		return basicSampleMDAO.selectSample(seq);
	}

	@Override
	public List<BasicSampleVO> selectSampleList(BasicSampleVO vo) throws Exception {
		return basicSampleMDAO.selectSampleList(vo); 
	}

	@Override
	public void updateSampleViewCount(String seq) throws Exception {
		basicSampleMDAO.updateSampleViewCount(seq);
	}

}
