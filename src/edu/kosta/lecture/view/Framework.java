package edu.kosta.lecture.view;

import edu.kosta.lecture.controller.LectureController;
import edu.kosta.lecture.model.Lecture;
import edu.kosta.lecture.response.ApiResponse;
import edu.kosta.lecture.response.GlobalException;
import edu.kosta.lecture.response.ResponseStatus;
import edu.kosta.lecture.util.ValidationChecker;

import java.util.ArrayList;
import java.util.Scanner;

public class Framework {
    static Scanner sc =new Scanner(System.in);
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

        boolean result = Framework.checker.analysis();
        if(result == false)
            throw new GlobalException("사용자 오류", ResponseStatus.BadRequest);

        ApiResponse res = null;
        while(true) {
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
                        LectureController.selectAll();
                        res = new ApiResponse();
                        break;
                    case 2:
                        LectureController.insert(new ArrayList<Lecture>());
                        break;
                    case 3:
                        LectureController.update(new Lecture());
                        break;
                    case 4:
                        LectureController.delete(new ArrayList<String>());
                        break;
                    case 5:
                        return null;
                    default:
                        System.out.println("잘못되었습니다..다시 입력해주세요.");
                        break;
                }

            }catch (Exception e) {
                throw new GlobalException(e.getMessage());
            }
        }//while문

        return res;
    }//메소드 end

    public static void teacherService() throws GlobalException {

        while(true) {
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
                        LectureController.selectAll();
                        break;
                    case 2:
                        LectureController.insert(new ArrayList<Lecture>());
                        break;
                    case 3:
                        LectureController.update(new Lecture());
                        break;
                    case 4:
                        LectureController.delete(new ArrayList<String>());
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("잘못되었습니다..다시 입력해주세요.");
                        break;
                }

            }catch (Exception e) {
                throw new GlobalException(e.getMessage());
            }
        }//while문
    }//메소드 end

    public static void studentService() throws GlobalException {

        while(true) {
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
                        LectureController.selectAll();
                        break;
                    case 2:
                        LectureController.insert(new ArrayList<Lecture>());
                        break;
                    case 3:
                        LectureController.update(new Lecture());
                        break;
                    case 4:
                        LectureController.delete(new ArrayList<String>());
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("잘못되었습니다..다시 입력해주세요.");
                        break;
                }

            }catch (Exception e) {
                throw new GlobalException(e.getMessage());
            }
        }//while문
    }//메소드 end


    public static void classroomService() throws GlobalException {

        while(true) {
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
                        LectureController.selectAll();
                        break;
                    case 2:
                        LectureController.insert(new ArrayList<Lecture>());
                        break;
                    case 3:
                        LectureController.update(new Lecture());
                        break;
                    case 4:
                        LectureController.delete(new ArrayList<String>());
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("잘못되었습니다..다시 입력해주세요.");
                        break;
                }

            }catch (Exception e) {
                throw new GlobalException(e.getMessage());
            }
        }//while문
    }//메소드 end

    public static void subjectService() throws GlobalException {

        while(true) {
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
                        LectureController.selectAll();
                        break;
                    case 2:
                        LectureController.insert(new ArrayList<Lecture>());
                        break;
                    case 3:
                        LectureController.update(new Lecture());
                        break;
                    case 4:
                        LectureController.delete(new ArrayList<String>());
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("잘못되었습니다..다시 입력해주세요.");
                        break;
                }

            }catch (Exception e) {
                throw new GlobalException(e.getMessage());
            }
        }//while문
    }//메소드 end

    public static void schedulerService() throws GlobalException {

        while(true) {
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
                        LectureController.selectAll();
                        break;
                    case 2:
                        LectureController.insert(new ArrayList<Lecture>());
                        break;
                    case 3:
                        LectureController.update(new Lecture());
                        break;
                    case 4:
                        LectureController.delete(new ArrayList<String>());
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("잘못되었습니다..다시 입력해주세요.");
                        break;
                }

            }catch (Exception e) {
                throw new GlobalException(e.getMessage());
            }
        }//while문
    }//메소드 end
}









