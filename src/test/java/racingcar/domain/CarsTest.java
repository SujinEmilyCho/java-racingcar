package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domian.Car;
import racingcar.domian.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void 가장_먼_자동차의_거리() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car(2, "user1"));
        cars.add(new Car(4, "user2"));
        cars.add(new Car(5, "user3"));
        cars.add(new Car(6, "user4"));
        Cars players = new Cars(cars);
        assertThat(players.findMaxPosition()).isEqualTo(6);
    }

}
