package com.mybatis3.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Student;

public class StudentDao {
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE=
			"com.mybatis3.dao.mapper.StudentMapper.";
	public StudentDao() {
		try {
			this.sqlSessionFactory=
					new SqlSessionFactoryBuilder()
					.build(Resources.getResourceAsStream("mybatis-config.xml")); 
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**************************************************
	1. SELECT[결과타입이 DTO[DTO List] 객체인경우] 
	**************************************************/
	/*
	 resultType :  DTO
	*/
	public Student findStudentById(Integer studId) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		Student student = sqlSession.selectOne(NAMESPACE+"findStudentById",studId);
		sqlSession.close();
		return student;
	}
	public List<Student> findStudentByNameLike(String name) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		List<Student> students = 
				sqlSession.selectList(NAMESPACE+"findStudentByNameLike","%"+name+"%");
		/*List<Student> students = 
				sqlSession.selectList(
						NAMESPACE+"findStudentByNameLike",name);*/
		sqlSession.close();
		return students;
	}

	public List<Student> findAllStudents() {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		List<Student> studentList=sqlSession.selectList(NAMESPACE+"findAllStudents");
		sqlSession.close();
		return studentList;
	}

	/*
	 * resultMap :  DTO
	 */
	public Student findStudentByIdResultMap(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		Student student=
				sqlSession.selectOne(NAMESPACE+"findStudentByIdResultMap",studId);
		sqlSession.close();
		return student;
	}

	public List<Student> findAllStudentsResultMap() {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		List<Student> studentList=
				sqlSession.selectList(NAMESPACE+"findAllStudentsResultMap");
		sqlSession.close();
		return studentList;
	}
	/*******************************************************************
	 2. SELECT[결과타입이 Wrapper(String)[Wrapper(String) List]객체인경우] 
	*******************************************************************/
	/*
	 * resultType :  String,Wrapper,List<Wrapper>,List<String>
	 */
	public String  findStudentNameById(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		
		String name=
				sqlSession.selectOne(NAMESPACE+"findStudentNameById",studId);
		sqlSession.close();
		return name;
	}
	public List<String> findStudentNameList(){
		SqlSession sqlSession=
				sqlSessionFactory.openSession(true);
		List<String> nameList=
				sqlSession.selectList(NAMESPACE+
						"findStudentNameList");
		sqlSession.close();
		return nameList;
	}
	/**************************************************
	 3. SELECT[student + address JOIN]( 1 : 1 )
	 **************************************************/
	/*
	 * resultMap : studentResultMap
	 */
	public Student findStudentByIdWithAddress(Integer studId) {
		SqlSession sqlSession=
				sqlSessionFactory.openSession(true);
		Student student=sqlSession
					.selectOne(NAMESPACE+"findStudentByIdWithAddress",studId);
		
		return student;
	}

	/*********************************************************
	 4. SELECT[students + course_enrollment [ +course ] JOIN( 1 : N )
	 ********************************************************/
	/*
	 * resultMap : studentResultMap
	 */
	public Student findStudentByIdWithCourses(Integer studId) {
		SqlSession sqlSession=
				sqlSessionFactory.openSession(true);
		
		Student student =
				sqlSession.selectOne(NAMESPACE+"findStudentByIdWithCourses",
						studId);
		
		return student;
	}
	/**************************************************
	 5. SELECT[students + address + courses[course_enrollment] JOIN( 1 : 1 : N )
	**************************************************/
	/*
	 * resultMap : studentWithAddressWithCoursesResultMap
	 */
	public Student findStudentByIdWithAddressAndCourses(Integer studId) {
		
		Student student =null;
		
		
		
		return student;
	}
	
	/**************************************************
	 * INSERT
	 ***************************************************/
	/*
	parameterType: DTO,VO,Domain
	*/
	public int insertStudentBySequence(Student student) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int rowCount=
			sqlSession.insert(NAMESPACE+"insertStudentBySequence", student);
		sqlSession.close();
		return rowCount;
	}
	public int insertStudentBySequenceReturnPrimaryKey(Student student) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int rowCount=
				sqlSession.insert(NAMESPACE+"insertStudentBySequenceReturnPrimaryKey", student);
		return student.getStudId();
	}



	/**************************************************
	 * UPDATE
	 ***************************************************/
	/*
	  parameterType: DTO,VO,Domain
	 */
	public int updateStudentById(Student updateStudent) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int rowCount=
				sqlSession.update(NAMESPACE+"updateStudentById",
									updateStudent);
		sqlSession.close();
		return rowCount;
	}

	/**************************************************
	 * DELETE
	 ***************************************************/
	/*
	 parameterType: java.lang.Integer,java.lang.String
	 */
	public int deleteStudentById(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int deleteRowCount=
			sqlSession.delete(NAMESPACE+"deleteStudentById",
					studId);
		return deleteRowCount;
	}
	/**************************************************
	 결과데이타를 Map(HashMap)에 담아서 반환할수있다
	***************************************************/
	/*
	resultType:Map,HashMap	
	*/
	public HashMap findStudentByIdMap(Integer studId) {
		SqlSession  sqlSession = sqlSessionFactory.openSession();
		HashMap findStudentMap=
				sqlSession.selectOne(NAMESPACE+"findStudentByIdMap",studId);
		
		sqlSession.commit();
		sqlSession.close();
		return findStudentMap;
	}
	
	public List<HashMap> findAllStudentsMapList(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		List<HashMap> studentMapList=
				sqlSession.selectList(NAMESPACE+"findAllStudentsMapList");
		sqlSession.close();
		return studentMapList;
	}
	
	/**************************************************
	 파라메타데이타를 Map(HashMap)에 담아서 전달할수있다
	***************************************************/
	public List<Student> findStudentByIdRangeParamMap(Map rangeMap){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		List<Student> studentList=
				sqlSession.
				selectList(NAMESPACE+"findStudentByIdRangeParamMap",rangeMap);
		sqlSession.close();
		return studentList;
	}
	public int updateStudentParamMap(Map studentMap){
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int rowCount=
				sqlSession.
				update(NAMESPACE+"updateStudentParamMap",studentMap);
		sqlSession.close();
		return rowCount;
	}
	public List<Student> findStudentsThreeParamMap(Map threeStudentMap){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		List<Student> studentList=
				sqlSession.
				selectList(NAMESPACE+"findStudentsThreeParamMap",threeStudentMap);
		sqlSession.close();
		
		
		
		return studentList;
	}
	
}











