package com.cpe.backend;


import com.cpe.backend.registeruser.entity.Gender;
import com.cpe.backend.registeruser.entity.PhoneType;
import com.cpe.backend.registeruser.entity.NameType;
import com.cpe.backend.registercompany.entity.Size;
import com.cpe.backend.registercompany.entity.Type;
import com.cpe.backend.registercompany.entity.Province;
//import com.cpe.backend.registercompany.entity.Company;
import com.cpe.backend.jobpost.entity.Position;
import com.cpe.backend.jobpost.entity.Benefits;
import com.cpe.backend.application.entity.Source;
import com.cpe.backend.resume.entity.Workexperience;
import com.cpe.backend.resume.entity.Education;



import com.cpe.backend.registeruser.repository.GenderRepository;
import com.cpe.backend.registeruser.repository.NameTypeRepository;
import com.cpe.backend.registeruser.repository.PhoneTypeRepository;
import com.cpe.backend.registercompany.repository.SizeRepository;
import com.cpe.backend.registercompany.repository.TypeRepository;
import com.cpe.backend.registercompany.repository.ProvinceRepository;
import com.cpe.backend.registercompany.repository.CompanyRepository;
import com.cpe.backend.jobpost.repository.PositionRepository;
import com.cpe.backend.jobpost.repository.BenefitsRepository;
import com.cpe.backend.application.repository.SourceRepository;
import com.cpe.backend.resume.repository.EducationRepository;
import com.cpe.backend.resume.repository.WorkexperienceRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	ApplicationRunner init(GenderRepository genderRepository, PhoneTypeRepository phonetypeRepository, NameTypeRepository nametypeRepository ,SizeRepository sizeRepository, TypeRepository 
	typeRepository, ProvinceRepository provinceRepository,PositionRepository positionRepository, BenefitsRepository benefitsRepository, CompanyRepository companyRepository
	,SourceRepository sourceRepository,EducationRepository educationRepository,WorkexperienceRepository workexperienceRepository) {
		return args -> {
			
			Stream.of("ชาย", "หญิง").forEach(name -> {
				Gender gender = new Gender();
				gender.setName(name);
				genderRepository.save(gender);
			});
			
			Stream.of("บริษัท", "มือถือ", "โทรศัพท์บ้าน").forEach(name -> {
				PhoneType phonetype = new PhoneType();
				phonetype.setName(name);
				phonetypeRepository.save(phonetype);
			});

			Stream.of("นาย", "นาง","นางสาว").forEach(name -> {
				NameType nameType = new NameType();
				nameType.setName(name);
				nametypeRepository.save(nameType);
			});

			Stream.of("วิสาหกิจขนาดย่อม","วิสาหกิจขนาดกลาง", "วิสาหกิจขนาดใหญ่").forEach(name -> {
				Size size = new Size();
				size.setName(name);
				sizeRepository.save(size);
			});
			
			Stream.of("กิจการเจ้าของคนเดียว", "ห้างหุ้นส่วนสามัญ", "ห้างหุ้นส่วนจำกัด",
			 "บริษัทจำกัด", "บริษัทมหาชนจำกัด", "องค์กรธุรกิจ").forEach(name -> {
				Type type = new Type();
				type.setName(name);
				typeRepository.save(type);
			});

			Stream.of("กรุงเทพมหานคร","กระบี่","กาญจนบุรี","กาฬสินธุ์","กำแพงเพชร","ขอนแก่น","จันทบุรี","ฉะเชิงเทรา","ชัยนาท","ชัยภูมิ","ชุมพร"
			,"ชลบุรี","เชียงใหม่","เชียงราย","ตรัง","ตราด","ตาก","นครนายก","นครปฐม","นครพนม","นครราชสีมา","นครศรีธรรมราช"
			,"นครสวรรค์","นราธิวาส","น่าน","นนทบุรี","บึงกาฬ","บุรีรัมย์","ประจวบคีรีขันธ์","ปทุมธานี","ปราจีนบุรี","ปัตตานี","พะเยา"
			,"พระนครศรีอยุธยา","พังงา","พิจิตร","พิษณุโลก","เพชรบุรี","เพชรบูรณ์","แพร่","พัทลุง","ภูเก็ต","มหาสารคาม","มุกดาหาร"
			,"แม่ฮ่องสอน","ยโสธร","ยะลา","ร้อยเอ็ด","ระนอง","ระยอง","ราชบุรี","ลพบุรี","ลำปาง","ลำพูน","เลย","ศรีสะเกษ","สกลนคร"
			,"สงขลา","สมุทรสาคร","สมุทรปราการ","สมุทรสงคราม","สระแก้ว","สระบุรี","สิงห์บุรี","สุโขทัย","สุพรรณบุรี","สุราษฎร์ธานี"
			,"สุรินทร์","สตูล","หนองคาย","หนองบัวลำภู","อำนาจเจริญ","อุดรธานี","อุตรดิตถ์","อุทัยธานี","อุบลราชธานี","อ่างทอง"
			
			).forEach(name -> {
				Province province = new Province();
				province.setName(name);
				provinceRepository.save(province);
			});
			Stream.of("ผู้จัดการฝ่ายบัญชี","พนักงานบัญชี", "หัวหน้าฝ่ายบัญชี","เจ้าหน้าที่ฝ่ายธุรการ", "ผู้จัดการฝ่ายธุรการ","แอร์ โอสเตส",
				   "สถาปนิก",
				   "ผู้กำกับฝ่ายศิลป์",
				   "วิศวกรทางด้านภาพและเสียง" ,
				   "ผู้ตรวจสอบบัญชี",
				   "พนักงานรับจ่ายเงิน",
				   "พนักงานเก็บบิล/เงิน",
				   "นายหน้าค้าหุ้นและพันธบัตร",
				   "ผู้จัดการฝ่ายงบประมาณ",
				   "นักวิเคราะห์ทางธุรกิจ",
				   "ที่ปรึกษาทางธุรกิจ",
				   "ผู้บริหารระดับสูง",
				   "วิศวกรโยธา",
				   "ช่างเทคนิคทางด้านสี",
				   "เจ้าหน้าที่ฝ่ายสินเชื่อธุรกิจ",
				   "ผู้ออกแบบภาพเคลื่อนไหว",
				   "วิศวกรด้านการออกแบบ",
				   "วิศวกรไฟฟ้า",
				   "นักออกแบบเสื้อผ้า",
				   "พนักงานทำความสะอาด",
				   "วิศวกรอุตสาหกรรม").forEach(name -> {
				Position position = new Position(); 
				position.setPosition(name); 
				positionRepository.save(position); 
			});

			Stream.of("ค่าน้ำมันรถ (ในพื้นที่, นอกพื้นที่)","ค่าโทรศัพท์","ประกันชีวิตพนักงานรายวัน,รายเดือน","โบนัส และ การปรับค่าจ้างประจำปี","กองทุนเงินทดแทน","รถส่วนตัว","ห้องพยาบาล","ตรวจสุขภาพประจำปี").forEach(name -> {
				Benefits benefits = new Benefits(); 
				benefits.setBenefits(name); 
				benefitsRepository.save(benefits); 
			});
			
			Stream.of("Website", "Newspaper", "Email").forEach(name -> {
				Source sourceType = new Source(); 
				sourceType.setName(name); 
				sourceRepository.save(sourceType); 
			});

			Stream.of("มัธยมศึกษาตอนต้น","มัธยมศึกษาตอนปลาย","ประกาศนียบัตรวิชาชีพ(ปวช.)","ประกาศนียบัตรวิชาชีพชั้นสูง(ปวส.)","ปริญญาตรี","ปริญญาโท","ปริญญาเอก").forEach(name -> {
				Education education = new Education(); 
				education.setName(name); 
				educationRepository.save(education); 
			});

			Stream.of("1เดือน","2เดือน","3เดือน","4เดือน","5เดือน","6เดือน","7เดือน","8เดือน","9เดือน","10เดือน","11เดือน","1ปี","2ปี","3ปี"
				,"4ปี","5ปี","6ปี","7ปี","8ปี","9ปี","10ปี","11ปี","12ปี","13ปี","14ปี","15ปี","16ปี","17ปี","18ปี","19ปี","20ปี").forEach(name -> {
				Workexperience workexperience = new Workexperience(); 
				workexperience.setName(name); 
				workexperienceRepository.save(workexperience); 
			});

			positionRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Customer บน Terminal
			benefitsRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Employee บน Terminal
			companyRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Video บน Terminal
			genderRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Customer บน Terminal
			phonetypeRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Employee บน Terminal
			nametypeRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity RentalType บน Terminal
			sizeRepository.findAll().forEach(System.out::println); // 
			provinceRepository.findAll().forEach(System.out::println); // 
			typeRepository.findAll().forEach(System.out::println); // 
			sourceRepository.findAll().forEach(System.out::println);
			educationRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Education บน Terminal
			workexperienceRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Workexperince บน Terminal
			
		};
	}

}
