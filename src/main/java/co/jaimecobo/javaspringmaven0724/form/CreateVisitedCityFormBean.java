package co.jaimecobo.javaspringmaven0724.form;


import co.jaimecobo.javaspringmaven0724.database.entity.City;
import co.jaimecobo.javaspringmaven0724.database.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class CreateVisitedCityFormBean {

    private Integer visitedCityId;

    private User user;

    private City city;

    private Integer cityVisited;

    private Date createdAt;

}
