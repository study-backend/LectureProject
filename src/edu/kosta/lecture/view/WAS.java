package edu.kosta.lecture.view;

import edu.kosta.lecture.controller.ClassRoomController;
import edu.kosta.lecture.controller.LectureController;
import edu.kosta.lecture.controller.SchedulerController;
import edu.kosta.lecture.controller.StudentContoller;
import edu.kosta.lecture.controller.SubjectController;
import edu.kosta.lecture.controller.TeacherController;
import edu.kosta.lecture.model.ClassRoom;
import edu.kosta.lecture.model.Lecture;
import edu.kosta.lecture.model.Student;
import edu.kosta.lecture.model.Subject;
import edu.kosta.lecture.model.Teacher;
import edu.kosta.lecture.response.ApiResponse;
import edu.kosta.lecture.response.GlobalException;
import edu.kosta.lecture.response.ResponseStatus;
import edu.kosta.lecture.util.ValidationChecker;

import java.util.ArrayList;
import java.util.Scanner;

public class WAS {
    static Scanner sc = new Scanner(System.in);
    static ValidationChecker checker = new ValidationChecker();

    /**
     * 메뉴
     * */
    public static void apiList() {

        while(true) {
            System.out.println("\n----------------------------------------");
            System.out.print("[1. 수강 API ");
            System.out.print("2. 강사 API ");
            System.out.print("3. 학생 API ");
            System.out.print("4. 강의실 API ");
            System.out.print("5. 과목 API ");
            System.out.print("6. 스케줄링 API ");
            System.out.print("7. 종료 ]");

            System.out.println("\n--------------------------------------------");
            System.out.println("선택메뉴는?");
            try {
                int menu = Integer.parseInt(sc.nextLine());//
                switch (menu) {
                    case 1:
                        lectureService();
                        break;
                    case 2:
                        teacherService();
                        break;
                    case 3:
                        studentService();
                        break;
                    case 4:
                        classroomService();
                        break;
                    case 5:
                        subjectService();
                        break;
                    case 6:
                        schedulerService();
                        break;
                    case 7:
                        System.out.println("다음에 다시 만나요~~^^ 로그아웃됩니다...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("잘못되었습니다..다시 입력해주세요.");
                        break;
                }

            }catch (GlobalException e) {
                System.out.println("메뉴는 숫자만 가능합니다.");
            }
        }//while문

    }

	public static ApiResponse lectureService() throws GlobalException {

		boolean result = WAS.checker.analysis(new String("json"));
		if (result == false)
			throw new GlobalException("사용자 오류", ResponseStatus.BadRequest);

		ApiResponse res = null;

		System.out.println("\n----------------------------------------");
		System.out.print("[1. 조회 API ");
		System.out.print("2. 추가 API ");
		System.out.print("3. 수정 API ");
		System.out.print("4. 삭제 API ");
		System.out.print("5. 상위메뉴 ]");
		System.out.println("\n--------------------------------------------");
		System.out.println("선택메뉴는?");
		try {
			int menu = Integer.parseInt(sc.nextLine());//
			switch (menu) {
			case 1:
				String json = LectureController.selectAll().toString();
				res = new ApiResponse("", ResponseStatus.Ok, json);
				break;
			case 2:
				LectureController.insert(new ArrayList<Lecture>());
				res = new ApiResponse("", ResponseStatus.NoContent);
				break;
			case 3:
				LectureController.update(new Lecture());
				res = new ApiResponse("", ResponseStatus.NoContent);
				break;
			case 4:
				LectureController.delete(new ArrayList<String>());
				res = new ApiResponse("", ResponseStatus.NoContent);
				break;
			case 5:
				break;
			default:
				System.out.println("잘못되었습니다..다시 입력해주세요.");
				break;
			}

		} catch (Exception e) {
			throw new GlobalException(e.getMessage());
		}
		return res;
	}// 메소드 end

    public static ApiResponse teacherService() throws GlobalException {
    	
		boolean result = WAS.checker.analysis(new String("json"));
		if (result == false)
			throw new GlobalException("사용자 오류", ResponseStatus.BadRequest);

		ApiResponse res = null;

		System.out.println("\n----------------------------------------");
		System.out.print("[1. 조회 API ");
		System.out.print("2. 추가 API ");
		System.out.print("3. 수정 API ");
		System.out.print("4. 삭제 API ");
		System.out.print("5. 상위메뉴 ]");
		System.out.println("\n--------------------------------------------");
		System.out.println("선택메뉴는?");
		try {
			int menu = Integer.parseInt(sc.nextLine());//
			switch (menu) {
			case 1:
				String json = TeacherController.selectAll().toString();
				res = new ApiResponse("", ResponseStatus.Ok, json);
				break;
			case 2:
				TeacherController.insert(new Teacher());
				res = new ApiResponse("", ResponseStatus.NoContent);
				break;
			case 3:
				TeacherController.update(new Teacher());
				res = new ApiResponse("", ResponseStatus.NoContent);
				break;
			case 4:
				TeacherController.delete(new ArrayList<String>());
				res = new ApiResponse("", ResponseStatus.NoContent);
				break;
			case 5:
				break;
			default:
				System.out.println("잘못되었습니다..다시 입력해주세요.");
				break;
			}

		} catch (Exception e) {
			throw new GlobalException(e.getMessage());
		}
		return res;
    }//메소드 end

    public static ApiResponse studentService() throws GlobalException {
    	
		boolean result = WAS.checker.analysis(new String("json"));
		if (result == false)
			throw new GlobalException("사용자 오류", ResponseStatus.BadRequest);

		ApiResponse res = null;

		System.out.println("\n----------------------------------------");
		System.out.print("[1. 조회 API ");
		System.out.print("2. 추가 API ");
		System.out.print("3. 수정 API ");
		System.out.print("4. 삭제 API ");
		System.out.print("5. 상위메뉴 ]");
		System.out.println("\n--------------------------------------------");
		System.out.println("선택메뉴는?");
		try {
			int menu = Integer.parseInt(sc.nextLine());//
			switch (menu) {
			case 1:
				String json = StudentContoller.selectAll().toString();
				res = new ApiResponse("", ResponseStatus.Ok, json);
				break;
			case 2:
				StudentContoller.insert(new Student());
				res = new ApiResponse("", ResponseStatus.NoContent);
				break;
			case 3:
				StudentContoller.update(new Student());
				res = new ApiResponse("", ResponseStatus.NoContent);
				break;
			case 4:
				StudentContoller.delete(new ArrayList<String>());
				res = new ApiResponse("", ResponseStatus.NoContent);
				break;
			case 5:
				break;
			default:
				System.out.println("잘못되었습니다..다시 입력해주세요.");
				break;
			}

		} catch (Exception e) {
			throw new GlobalException(e.getMessage());
		}
		return res;
    }//메소드 end


    public static ApiResponse classroomService() throws GlobalException {
    	
		boolean result = WAS.checker.analysis(new String("json"));
		if (result == false)
			throw new GlobalException("사용자 오류", ResponseStatus.BadRequest);

		ApiResponse res = null;

		System.out.println("\n----------------------------------------");
		System.out.print("[1. 조회 API ");
		System.out.print("2. 추가 API ");
		System.out.print("3. 수정 API ");
		System.out.print("4. 삭제 API ");
		System.out.print("5. 상위메뉴 ]");
		System.out.println("\n--------------------------------------------");
		System.out.println("선택메뉴는?");
		try {
			int menu = Integer.parseInt(sc.nextLine());//
			switch (menu) {
			case 1:
				String json = ClassRoomController.selectAll().toString();
				res = new ApiResponse("", ResponseStatus.Ok, json);
				break;
			case 2:
				ClassRoomController.insert(new ArrayList<ClassRoom>());
				res = new ApiResponse("", ResponseStatus.NoContent);
				break;
			case 3:
				ClassRoomController.update(new ClassRoom());
				res = new ApiResponse("", ResponseStatus.NoContent);
				break;
			case 4:
				ClassRoomController.delete(new ArrayList<String>());
				res = new ApiResponse("", ResponseStatus.NoContent);
				break;
			case 5:
				break;
			default:
				System.out.println("잘못되었습니다..다시 입력해주세요.");
				break;
			}

		} catch (Exception e) {
			throw new GlobalException(e.getMessage());
		}
		return res;
    }//메소드 end

    public static ApiResponse subjectService() throws GlobalException {
    	
		boolean result = WAS.checker.analysis(new String("json"));
		if (result == false)
			throw new GlobalException("사용자 오류", ResponseStatus.BadRequest);

		ApiResponse res = null;

		System.out.println("\n----------------------------------------");
		System.out.print("[1. 조회 API ");
		System.out.print("2. 추가 API ");
		System.out.print("3. 수정 API ");
		System.out.print("4. 삭제 API ");
		System.out.print("5. 상위메뉴 ]");
		System.out.println("\n--------------------------------------------");
		System.out.println("선택메뉴는?");
		try {
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				String json = SubjectController.selectAll().toString();
				res = new ApiResponse("", ResponseStatus.Ok, json);
				break;
			case 2:
				SubjectController.insert(new ArrayList<Subject>());
				res = new ApiResponse("", ResponseStatus.NoContent);
				break;
			case 3:
				SubjectController.update(new Subject());
				res = new ApiResponse("", ResponseStatus.NoContent);
				break;
			case 4:
				SubjectController.delete(new ArrayList<String>());
				res = new ApiResponse("", ResponseStatus.NoContent);
				break;
			case 5:
				break;
			default:
				System.out.println("잘못되었습니다..다시 입력해주세요.");
				break;
			}

		} catch (Exception e) {
			throw new GlobalException(e.getMessage());
		}
		return res;
    }//메소드 end

    public static ApiResponse schedulerService() throws GlobalException {
    	
		boolean result = WAS.checker.analysis(new String("json"));
		if (result == false)
			throw new GlobalException("사용자 오류", ResponseStatus.BadRequest);

		ApiResponse res = null;

		System.out.println("\n----------------------------------------");
		System.out.print("[1. 스케줄링시작 API ");
//		System.out.print("2. 추가 API ");
//		System.out.print("3. 수정 API ");
//		System.out.print("4. 삭제 API ");
		System.out.print("2. 상위메뉴 ]");
		System.out.println("\n--------------------------------------------");
		System.out.println("선택메뉴는?");
		try {
			int menu = Integer.parseInt(sc.nextLine());//
			switch (menu) {
			case 1:
				SchedulerController.startScheduling();
				res = new ApiResponse("", ResponseStatus.Ok);
				break;
			case 2:
				break;
			default:
				System.out.println("잘못되었습니다..다시 입력해주세요.");
				break;
			}

		} catch (Exception e) {
			throw new GlobalException(e.getMessage());
		}
		return res;
    }//메소드 end
}









