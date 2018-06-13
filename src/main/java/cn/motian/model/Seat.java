package cn.motian.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Seat {
    private String unionId;
    private String StudioId;
    private int row;
    private int col;
    private String status;

    public Seat() {
    }

    public Seat(String studioId, int row, int col, String status) {
        StudioId = studioId;
        this.row = row;
        this.col = col;
        this.status = status;
    }


}