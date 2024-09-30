package com.mybatis3.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.mybatis3.domain.Student;

public interface StudentMapper {
	/*
	 * 인터페이스의 풀네임은 StudentMapper.xml의 namespace와일치
	 * 메쏘드이름은 	StudentMapper.xml 파일의 id와일치
	 * 메쏘드인자타입은 StudentMapper.xml 파일의 parameterType 와일치
	 * 메쏘드리턴타입은 StudentMapper.xml 파일의 resultType 와일치(ResultSet이 1개이상일경우는 List)
	 */
	/**************************************************
	1. SELECT[결과타입이 DTO[DTO List] 객체인경우] 
	**************************************************/
	@ResultType(Student.class)
	@Select("select stud_id as studid ,name,email,dob,phone from students where stud_id=#{studId}")
	public Student findStudentById(@Param("studId") Integer studId);
	
	@ResultType(Student.class)
	@Select("select stud_id as studid,name,email,dob from students")
	public List<Student> findAllStudents();
	
	@ResultMap("studentResultMap")
	@Select("select stud_id ,name,email,dob,phone from students where stud_id=#{studId}")
	public Student findStudentByIdResultMap(Integer studId);
	
	@ResultMap("studentResultMap")
	@Select("select stud_id ,name,email,dob,phone from students")
	public List<Student> findAllStudentsResultMap();
	
	
	/**************************************************
	 3. SELECT[student + address JOIN]( 1 : 1 )
	 **************************************************/
	@ResultMap("studentResultMap")
	@Select("select stud_id, name,dob,email,phone, a.addr_id, street, city, state, zip, country\r\n"
			+ "  		FROM students s \r\n"
			+ "      	left outer join addresses a \r\n"
			+ "      	on s.addr_id=a.addr_id\r\n"
			+ "      	where s.stud_id=#{studId}")
	Student findStudentByIdWithAddress(@Param("studId") Integer studId) ;
	/*********************************************************
	 4. SELECT[students + course_enrollment(+course)] JOIN( 1 : N )
	 ********************************************************/
	@ResultMap("studentResultMap")
	@Select("select  s.stud_id,s.name ,s.email,s.phone,s.dob ,\r\n"
			+ "        		c.course_id,c.name as course_name ,\r\n"
			+ "        		c.description,c.start_date,c.end_date\r\n"
			+ "		from students s \r\n"
			+ "		left outer join course_enrollment ce\r\n"
			+ "		on s.stud_id = ce.stud_id\r\n"
			+ "		left outer join courses c\r\n"
			+ "		on ce.course_id=c.course_id where s.stud_id=#{studId}")
	Student findStudentByIdWithCourses(Integer studId);

	
	/**************************************************
	 * INSERT
	 ***************************************************/
	
	@Insert("insert into students(stud_id,name,phone,email,dob) values(students_stud_id_seq.nextval,#{name},#{phone},#{email},#{dob})")
	int insertStudentBySequence(Student student);
	
	
	
	@SelectKey(before = true,
			   resultType = java.lang.Integer.class,
			   keyProperty = "studId",
			   statement = "select students_stud_id_seq.nextval from dual"
			  )
	@Insert("insert into students(stud_id,name,phone,email,dob) values(#{studId},#{name},#{phone},#{email},#{dob})")
	int insertStudentBySequenceReturnPrimaryKey(Student student);
	/**************************************************
	 * UPDATE
	 ***************************************************/
	@Update("update students set name=#{name},\r\n"
			+ "							email=#{email},\r\n"
			+ "							phone=#{phone},\r\n"
			+ "							dob=#{dob}\r\n"
			+ "		where stud_id=#{studId}	")
	int updateStudentById(Student updateStudent);
	/**************************************************
	 * DELETE
	 ***************************************************/
	@Delete("delete from students where stud_id=#{studId}")
	int deleteStudentById(Integer studId);

	
}