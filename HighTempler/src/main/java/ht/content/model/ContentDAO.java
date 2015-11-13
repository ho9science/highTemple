package ht.content.model;

import java.util.ArrayList;

public interface ContentDAO {

	/**
	 * 사찰의 고유번호를 받아서 사찰 DTO를 반환하는 메서드
	 * @param idx 사찰 검색 번호 
	 * @return 사찰 DTO
	 */
	ContentDTO getTempleInfo (int idx);
	
	/**
	 *  1부터 41번 까지의 모든 사찰 정보를 List로 가져옴
	 * @return 모든 사찰 정보의 ArrayList
	 */
	ArrayList<ContentDTO> getAllTempleInfo () ;
	
	/**
	 * 사찰을 이름으로 검색함
	 * MongoDB 사용
	 * @return
	 */
	ArrayList<ContentDTO> searchTemple (String query);
}
