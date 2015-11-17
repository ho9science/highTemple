package ht.imageSearch.model;

import java.util.List;

public interface ImageSearchDAO {
	public List<ImageSearchDTO> imageSearch(String keyword);
}
