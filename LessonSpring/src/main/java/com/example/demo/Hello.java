package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



import com.example.db.Dbutil;

@Controller
public class Hello {
	
	@Autowired
	private SingleScope singleScope;
	private String message;
	
	//test
	@RequestMapping(value = "/test",method = RequestMethod.GET)
	public ModelAndView Test() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("count", singleScope.getCount());
		modelAndView.setViewName("test");
		return modelAndView;
	}
	
	//添加学生成绩
	@GetMapping(value = "/insSco")
	public ModelAndView insSco(@RequestParam("id")String id,@RequestParam("period")int period,
			                   @RequestParam("math")String math,@RequestParam("eng")String eng,@RequestParam("phy")String phy) {
		ModelAndView modelAndView = new ModelAndView();
		Dbutil dbutil = new Dbutil();
		if (id==""||math==""||eng==""||phy=="") {
            modelAndView.addObject("message", "不可为空");
            //modelAndView.addObject("username",username);
			modelAndView.setViewName("div3");
			return modelAndView;
		}else {
			int a = Integer.parseInt(id);
			int b = Integer.parseInt(math);
			int c = Integer.parseInt(eng);
			int d = Integer.parseInt(phy);
			if (a==0||b==0||c==0||d==0) {
				modelAndView.addObject("message", "不可为0");
	            //modelAndView.addObject("username",username);
				modelAndView.setViewName("div3");
				return modelAndView;
			}else {
				dbutil.insertScore(a, period, b, c, d);
				modelAndView.addObject("message", "操作成功");
	            //modelAndView.addObject("username",username);
				modelAndView.setViewName("div3");
				return modelAndView;
			}
		}
	}
	
	//添加学生信息
	@RequestMapping(value = "/insStu",method = RequestMethod.GET)
	public ModelAndView insStu(@RequestParam("id")String id,@RequestParam("name")String name,
                               @RequestParam("age")String age,@RequestParam("sex")String sex,@RequestParam("classId")String classId,
                               @RequestParam("grade")String grade) {
		ModelAndView modelAndView = new ModelAndView();
		Dbutil dbutil = new Dbutil();
		if (id==""||name==""||age==""||sex==""||classId==""||grade=="") {
			modelAndView.addObject("message", "不可为空");
			//modelAndView.addObject("username",username);
			modelAndView.setViewName("div2");
			return modelAndView;
		}else {
			int a = Integer.parseInt(id);
			int b = Integer.parseInt(age);
			char c = sex.toCharArray()[0];
			int d = Integer.parseInt(classId);
			int e = Integer.parseInt(grade);
			if (a==0||b==0||c=='0'||d==0||e==0) {
				modelAndView.addObject("message", "不可为0");
				//modelAndView.addObject("username",username);
				modelAndView.setViewName("div2");
				return modelAndView;
			}else {
				dbutil.insertStu(a, name, b, c, d, e);
				modelAndView.addObject("message", "操作成功");
				//modelAndView.addObject("username",username);
				modelAndView.setViewName("div2");
				return modelAndView;
			}
		}
	}
	
	
	//登录界面
	@RequestMapping(value = "/hello",method = RequestMethod.GET)
	public String getHello() {
		
		return "index";
	}
	//跳转注册界面
	@RequestMapping(value = "/toregister",method = RequestMethod.GET)
	public String toRegister() {
		
		return "register";
	}
	//用户注册
	@RequestMapping(value = "/register",method = RequestMethod.GET)
	public ModelAndView register(@RequestParam("username") String username,@RequestParam("password") String password) {
		ModelAndView modelAndView = new ModelAndView();
		Dbutil util = new Dbutil(); 
		try {
			if (username!=""&&password!="") {
				util.addLogInfo(username,password);
				//int a = 1/0; //事物测试
				modelAndView.addObject("message","注册成功");
				modelAndView.setViewName("register");
				return modelAndView;
			}else {
				modelAndView.addObject("message","用户名或密码不能为空");
				modelAndView.setViewName("register");
				return modelAndView;
			}
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.addObject("message","请重新输入!!");
			modelAndView.setViewName("register");
			return modelAndView;
		}
		
	}
	//登录验证
	//@transaction
	@RequestMapping(value = "/enter",method = RequestMethod.GET)
	public ModelAndView enter(@RequestParam("username") String username,@RequestParam("password") String password,
			                  HttpSession session, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		Dbutil util = new Dbutil();
		session = request.getSession();
		List<LogInfo> logInfos = util.getLogInfos();
		for (LogInfo logInfo : logInfos) {
			if ((logInfo.getLoginId()).equals(username)&&(logInfo.getPassword()).equals(password)&&username!="") {
				//modelAndView.addObject("username",username);
				session.setAttribute("logInfo", logInfo);
				session.setMaxInactiveInterval(120);
				modelAndView.setViewName("success");
				return modelAndView;
			}
		}
		modelAndView.setViewName("index");
		modelAndView.addObject("message","请重新输入");
		return modelAndView;
	}
	//跳转查询界面
	@RequestMapping(value = "/div1",method = RequestMethod.GET)
	public ModelAndView toDiv1() {
		ModelAndView modelAndView = new ModelAndView();
		//modelAndView.addObject("username",username);
		modelAndView.setViewName("div1");
		return modelAndView;
	}
	//跳转添加学生信息界面
	@RequestMapping(value = "/div2",method = RequestMethod.GET)
	public ModelAndView toDiv2() {
		ModelAndView modelAndView = new ModelAndView();
		//modelAndView.addObject("username",username);
		modelAndView.setViewName("div2");
		return modelAndView;
	}
	//跳转添加成绩界面
	@RequestMapping(value = "/div3",method = RequestMethod.GET)
	public ModelAndView toDiv3() {
		ModelAndView modelAndView = new ModelAndView();
		//modelAndView.addObject("username",username);
		modelAndView.setViewName("div3");
		return modelAndView;
	}
	//跳转更新界面
	@RequestMapping(value = "/div4",method = RequestMethod.GET)
	public ModelAndView toDiv4() {
		ModelAndView modelAndView = new ModelAndView();
		//modelAndView.addObject("username",username);
		modelAndView.setViewName("div4");
		return modelAndView;
	}
	//跳转更新成绩界面
	@RequestMapping(value = "/div5",method = RequestMethod.GET)
	public ModelAndView toDiv5() {
		ModelAndView modelAndView = new ModelAndView();
		//modelAndView.addObject("username",username);
		modelAndView.setViewName("div5");
		return modelAndView;
	}
	//跳转删除界面
	@RequestMapping(value = "/div6",method = RequestMethod.GET)
	public ModelAndView toDiv6() {
		ModelAndView modelAndView = new ModelAndView();
		//modelAndView.addObject("username",username);
		modelAndView.setViewName("div6");
		return modelAndView;
	}
	//按学号删除
	@RequestMapping(value = "/delById",method = RequestMethod.GET)
	public ModelAndView delById(@RequestParam("id") String id) {
		ModelAndView modelAndView = new ModelAndView();
		Dbutil dbutil = new Dbutil();
		if (id=="") {
			modelAndView.addObject("message", "查无此人");
			//modelAndView.addObject("username",username);
			modelAndView.setViewName("div6");
			return modelAndView;
		}else {
			Student student = dbutil.searchStu(id);
			if (student!=null) {
				int a = Integer.parseInt(id);
				dbutil.deleteStu(a);
				modelAndView.addObject("message", "删除成功");
				//modelAndView.addObject("username",username);
				modelAndView.setViewName("div6");
				return modelAndView;
			}else {
				modelAndView.addObject("message", "查无此人");
			    //modelAndView.addObject("username",username);
			    modelAndView.setViewName("div6");
			    return modelAndView;
			}
		}
	}	
	//按学号查找
	@RequestMapping(value = "/sByid",method = RequestMethod.GET)
	public ModelAndView searchByid(@RequestParam("id") String id) {
		ModelAndView modelAndView = new ModelAndView();
		Dbutil dbutil = new Dbutil();
		
		if (id.equals("")) {
			modelAndView.addObject("message", "查无此人");
			//modelAndView.addObject("username",username);
			modelAndView.setViewName("div1");
			return modelAndView;
		}else {
			Student student = dbutil.searchStu(id);
			
		    if (student!=null) {
			    modelAndView.addObject("value", student);
			    //modelAndView.addObject("username",username);
			    modelAndView.addObject("message", "查询成功");
			    modelAndView.setViewName("div1");
			    return modelAndView;
		    }else {
			    modelAndView.addObject("message", "查无此人");
			    //modelAndView.addObject("username",username);
			    modelAndView.setViewName("div1");
			    return modelAndView;
		    }  
		}
	}
	//更新学生信息--按学号查找
		@RequestMapping(value = "/searchById",method = RequestMethod.GET)
		public ModelAndView searchById(@RequestParam("id") String id) {
			ModelAndView modelAndView = new ModelAndView();
			Dbutil dbutil = new Dbutil();
			
			if (id=="") {
				modelAndView.addObject("message", "查无此人");
				//modelAndView.addObject("username",username);
				modelAndView.setViewName("div4");
				return modelAndView;
			}else {
				Student student = dbutil.searchStu(id);
				
			    if (student!=null) {
				    modelAndView.addObject("value", student);
				    //modelAndView.addObject("username",username);
				    modelAndView.addObject("message", "查询成功");
				    modelAndView.setViewName("div4");
				    return modelAndView;
			    }else {
				    modelAndView.addObject("message", "查无此人");
				    //modelAndView.addObject("username",username);
				    modelAndView.setViewName("div4");
				    return modelAndView;
			    }  
			}
		}
		
	//更新学生成绩--按学号查找
	@RequestMapping(value = "/sScoById",method = RequestMethod.GET)
	public ModelAndView sScoById(@RequestParam("id") String id) {
		ModelAndView modelAndView = new ModelAndView();
		Dbutil dbutil = new Dbutil();
		if (id=="") {
			modelAndView.addObject("message", "查无此人");
			//modelAndView.addObject("username",username);
			modelAndView.setViewName("div5");
			return modelAndView;
			}else {
			Student student = dbutil.searchStu(id);
			if (student!=null) {
				modelAndView.addObject("value1", student);
				modelAndView.addObject("value2", student.getScore());
				//modelAndView.addObject("username",username);
				modelAndView.addObject("message", "查询成功");
				modelAndView.setViewName("div5");
				return modelAndView;
				}else {
					modelAndView.addObject("message", "查无此人");
					//modelAndView.addObject("username",username);
					modelAndView.setViewName("div5");
					return modelAndView;
				}  
		}
	}
	//返回登录成功界面
	@RequestMapping(value = "/backto",method = RequestMethod.GET)
	public ModelAndView backToEnter() {
		ModelAndView modelAndView = new ModelAndView();
		//modelAndView.addObject("username", username);
		modelAndView.setViewName("success");
		return modelAndView;
		}
	//跳转按条件查询界面
	@RequestMapping(value = "/toSByCon",method = RequestMethod.GET)
	public ModelAndView toSByCon() {
		ModelAndView modelAndView = new ModelAndView();
		//modelAndView.addObject("username",username);
		modelAndView.setViewName("sByCon");
		return modelAndView;
	}
	//按条件查询
	@RequestMapping(value = "/sByCon",method = RequestMethod.GET)
	public ModelAndView sByCon(@RequestParam("id")String id,@RequestParam("name")String name,
			                   @RequestParam("age")String age,@RequestParam("sex")String sex,@RequestParam("classId")String classId,
			                   @RequestParam("grade")String grade) {
		ModelAndView modelAndView = new ModelAndView();
		Dbutil dbutil = new Dbutil();
		List<Student> students = new ArrayList<Student>();
		String where = "where ";
		//判断id
		if (id!="") {
			int a = Integer.parseInt(id);
			if (a!=0) {
				if (where.length()>6) {
					where += " and ";
				}
			    where += " id = " + id;
			}
		}
		//判断name
		if (name!="") {
			if (where.length()>6) {
				where += " and ";
			}
			where += " name = " + name;
		}
		//判断age
		if (age!="") {
			int b = Integer.parseInt(age);
			if (b!=0) {
				if (where.length()>6) {
					where += " and ";
				}
				where += " age = " + age;
			}
		}
		//判断sex
		if (sex!="") {
			char c = sex.toCharArray()[0];
			if (c!='0') {
				if (where.length()>6) {
					where += " and ";
				}
				where += " sex = " + "'" +sex+ "'";
			}
		}
		//判断grade
		if (grade!="") {
			int d = Integer.parseInt(grade);
			if (d!=0) {
				if (where.length()>6) {
					where += " and ";
				}
				where += " grade = " + grade;
			}
		}
		//判断classId
		if (classId!="") {
			int e = Integer.parseInt(classId);
			if (e!=0) {
				if (where.length()>6) {
					where += " and ";
				}
				where += " classId = " + classId;
			}
		}
		students = dbutil.stuList(where);
		if (!students.isEmpty()) {
			modelAndView.addObject("listValue", students);
			//modelAndView.addObject("username",username);
			modelAndView.addObject("message", "查询成功");
			modelAndView.setViewName("sByCon");
			return modelAndView;
		} else {
			//modelAndView.addObject("username",username);
			modelAndView.addObject("message", "查无此人");
			modelAndView.setViewName("sByCon");
			return modelAndView;
        }
		
	}
	//更新学生信息
	@RequestMapping(value = "/upStu",method = RequestMethod.GET)
	public ModelAndView upStu(@RequestParam("id")int id,@RequestParam("name")String name,@RequestParam("age")int age,
			                  @RequestParam("sex")char sex,@RequestParam("classId")int classId,@RequestParam("grade")int grade) {
			                 
		ModelAndView modelAndView = new ModelAndView();
		Dbutil dbutil = new Dbutil();
		dbutil.updateStu(id, name, age, sex, grade, classId);
		//modelAndView.addObject("username",username);
		modelAndView.addObject("message", "更新成功");
		modelAndView.setViewName("div4");
		return modelAndView;
	}
	//更新学生信息
	@RequestMapping(value = "/upSco",method = RequestMethod.GET)
	public ModelAndView upSco(@RequestParam("id")int id,@RequestParam("period")int period,@RequestParam("math")int math,
			                  @RequestParam("eng")int eng,@RequestParam("phy")int phy) {
		ModelAndView modelAndView = new ModelAndView();
		Dbutil dbutil = new Dbutil();
		dbutil.updateScore(id, period, math, eng, phy);
		//modelAndView.addObject("username",username);
		modelAndView.addObject("message", "更新成功");
		modelAndView.setViewName("div5");
		return modelAndView;
	}
	//test
	@RequestMapping(value = "/hello2",method = RequestMethod.GET)
	public ModelAndView getHello2(@RequestParam("id") int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("username","zhangsan");
		
		List<Student> stu = new ArrayList<Student>();
		Student student1 = new Student();
		student1.setId(1);
		student1.setName("kobe");
		student1.setAge(20);
		
		Student student2 = new Student();
		student2.setId(2);
		student2.setName("james");
		student2.setAge(25);
		
		stu.add(student1);
		stu.add(student2);
		
		modelAndView.addObject("listValue",stu);
		
		modelAndView.setViewName("index2");
		return modelAndView;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}






