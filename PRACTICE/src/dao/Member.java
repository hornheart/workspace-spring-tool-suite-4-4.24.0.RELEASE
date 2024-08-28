package dao;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Member {
	private int no;;
	private String name;
	private String phone;
	private String address;
	private String type;
	private int license_no;
	private Date reg_date;
}