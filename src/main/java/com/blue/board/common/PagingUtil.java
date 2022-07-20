package com.blue.board.common;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.blue.board.vo.CommonVO;

 
/**
 * ������ �׺���̼� ���� ������ ���� Ŭ����
 */
public class PagingUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(PagingUtil.class);
 
	
	
	
	
	// test �׽�Ʈ �޼���!
    public static CommonVO setPageUtil(CommonVO commonVO) {
 
    	CommonVO commonPageVO = new CommonVO();
    	logger.debug("###### PagingUtil.setPageUtil");
        String pagination = ""; // ����¡ ��� ��
        String functionName = commonVO.getFunctionName();
        int currentPage = commonVO.getCurrentPageNo(); // ���� ������ ��ȣ
        int countPerList = commonVO.getCountPerPage(); // �� ȭ�鿡 ��µ� �Խù� ��
        int countPerPage = commonVO.getCountPerList(); // �� ȭ�鿡 ��µ� ������ ��
        int totalListCount = commonVO.getTotalCount(); // �� �Խù� ��
        int totalPageCount = totalListCount / countPerList; // �� ������ ��
        
        if (totalListCount % countPerList > 0) { // �� ���̼��� ���� �� int������ ����ϸ� �������� �ִ� ��� �Խù��� �����ϱ� ������ �� �������� ���� ����
            totalPageCount = totalPageCount + 1;
        }
 
        int viewFirstPage = (((currentPage - 1) / countPerPage) * countPerPage) + 1; // �� ȭ�鿡 ù ������ ��ȣ
        int ViewLastPage = viewFirstPage + countPerPage - 1; // �� ȭ�鿡 ������ ������ ��ȣ
        if (ViewLastPage > totalPageCount) { // ������ �������� ���� �� �������� ������ ū ���� �Խù��� �������� �ʱ� ������ ������ �������� ���� ����
            ViewLastPage = totalPageCount;
        }
 
        int totalFirstPage = 1; // ��ü ������ �߿� ó�� ������
        int totalLastPage = totalPageCount; // ��ü ������ �߿� ������ ������
        int prePerPage = 0; // ���� ȭ�鿡 ù��° ��ȣ
        if (viewFirstPage - countPerPage > 0) {
            prePerPage = viewFirstPage - countPerPage;
        } else {
            prePerPage = totalFirstPage;
        }
        int nextPerPage = 0; // ���� ȭ�鿡 ù��° ��ȣ
        if (viewFirstPage + countPerPage < totalPageCount) {
            nextPerPage = viewFirstPage + countPerPage;
        } else {
            nextPerPage = totalPageCount;
        }
        

 
        // ������ ���̰��̼� ����
        pagination += "<div class='pagination'>";
        pagination += "<a href='javascript:" + functionName + "(\"" + totalFirstPage + "\");' class=\"direction_left01\">[<<]</a>";
        pagination += "<a href='javascript:" + functionName + "(" + prePerPage + ");' class=\"direction_left01\">[<]</a>";
        for (int a = viewFirstPage; a <= ViewLastPage; a++) {
            if (a == currentPage) {
                pagination += "<a href='javascript:" + functionName + "(\"" + a + "\");' class='onpage'>[" + a + "]</a>";
            } else {
                pagination += "<a href='javascript:" + functionName + "(\"" + a + "\");'>[" + a + "]</a>";
            }
        }
        pagination += "<a href='javascript:" + functionName + "(" + nextPerPage + ");' class=\"direction_right01\">[>]</a>";
        pagination += "<a href='javascript:" + functionName + "(" + totalLastPage + ");' class=\"direction_right01\">[>>]</a>";
        pagination += "</div>";
 
        //int offset = ((currentPage - 1) * countPerList); // �� ȭ���� ǥ��Ǵ� �Խù��� ���� ��ȣ (���� ������)
        
        int startNo = ((currentPage - 1) * countPerPage) + 1;
        int endNo = currentPage * countPerPage; 
        // LIMIT�� ������ row�� ��, OFFSET�� �� ��° row���� ���������� ����
        //commonPageVO.setStartNo(countPerList);
        //commonPageVO.setEndNo(offset);
        commonPageVO.setStartNo(startNo);
        commonPageVO.setEndNo(endNo);
        commonPageVO.setPagination(pagination);
        
        logger.debug("###### currentPage :: " + currentPage);
        logger.debug("###### countPerList :: " + countPerList);
        logger.debug("###### countPerPage :: " + countPerPage);
        logger.debug("###### totalListCount :: " + totalListCount);
        logger.debug("###### totalPageCount :: " + totalPageCount);
        logger.debug("###### viewFirstPage :: " + viewFirstPage);
        logger.debug("###### ViewLastPage :: " + ViewLastPage);
        logger.debug("###### totalFirstPage :: " + totalFirstPage);
        logger.debug("###### totalLastPage :: " + totalLastPage);
        logger.debug("###### prePerPage :: " + prePerPage);
        logger.debug("###### nextPerPage :: " + nextPerPage);
        logger.debug("###### currentPage :: " + currentPage);
        logger.debug("###### startNo :: " + countPerList);
        //logger.debug("###### endNo :: " + offset);
 
        return commonPageVO;
    }
}