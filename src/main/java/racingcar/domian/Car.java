package racingcar.domian;

import racingcar.util.StringUtils;

import java.util.Objects;

public class Car {
    private static final String EMPTY_STRING = "";
    private static final int INIT_POSITION = 0;
    private static final int LIMIT_FOR_MOVE = 4;
    private static final int NAME_LENGTH_LIMIT = 5;

    private int position;
    private String name;

    public Car(String name) {
        this(INIT_POSITION, name);
    }

    public Car(int position, String name) {
        this.position = position;
        this.name = validName(name);
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return name;
    }

    private static String validName(String name) {
        name = StringUtils.validNullOrEmpty(name);
        validNameLength(name);
        return name;
    }

    private static void validNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("이름 길이 5자 초과입니다!");
        }
    }

    public void moveByRandom(int inputValue) {
        if (inputValue >= LIMIT_FOR_MOVE) {
            this.position++;
        }
    }

    public String isWinner(int max) {
        if (isMaxPosition(max)) {
            return name;
        }
        return EMPTY_STRING;
    }

    private boolean isMaxPosition(int max) {
        return this.position == max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
