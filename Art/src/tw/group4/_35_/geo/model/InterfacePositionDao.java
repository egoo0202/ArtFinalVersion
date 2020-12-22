package tw.group4._35_.geo.model;

import java.util.List;

public interface InterfacePositionDao {

	List<Position> readAllToPt();

	List<Position> readNoNullToPt();

	List<Position> selectByCategory(Integer Category);

}