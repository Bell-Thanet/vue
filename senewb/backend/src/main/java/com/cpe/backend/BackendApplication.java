package com.cpe.backend;

import com.cpe.backend.Members.entity.Nametype;
import com.cpe.backend.Members.entity.Gender;
import com.cpe.backend.Members.entity.Province;
import com.cpe.backend.Returns.entity.Status;
import com.cpe.backend.Employee.entity.Position;
import com.cpe.backend.Employee.entity.Phonetype;
import com.cpe.backend.Employee.entity.AdminID;

import com.cpe.backend.Members.repository.GenderRepository;
import com.cpe.backend.Members.repository.NametypeRepository;
import com.cpe.backend.Members.repository.ProvinceRepository;
import com.cpe.backend.Returns.repository.StatusRepository;
import com.cpe.backend.Sportequipment.entity.Category;
import com.cpe.backend.Sportequipment.entity.Sporttype;
import com.cpe.backend.Sportequipment.repository.CategoryRepository;
import com.cpe.backend.Sportequipment.repository.SporttypeRepository;
import com.cpe.backend.Employee.repository.PositionRepository;
import com.cpe.backend.Employee.repository.PhonetypeRepository;
import com.cpe.backend.Employee.repository.AdminIDRepository;

import com.cpe.backend.Reservation.entity.Reservation;
import com.cpe.backend.Reservation.entity.Fieldtype;
import com.cpe.backend.Reservation.entity.Fielduse;
import com.cpe.backend.Reservation.repository.ReservationRepository;
import com.cpe.backend.Reservation.repository.FieldtypeRepository;
import com.cpe.backend.Reservation.repository.FielduseRepository;

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
	ApplicationRunner init(ProvinceRepository provinceRepository,NametypeRepository nametypeRepository,GenderRepository genderRepository,StatusRepository statusRepository,PositionRepository positionRepository,PhonetypeRepository phonetypeRepository,
	CategoryRepository categoryRepository,SporttypeRepository sporttypeRepository,AdminIDRepository adminIDRepository,ReservationRepository reservationRepository,
	FieldtypeRepository fieldtypeRepository,FielduseRepository fielduseRepository) {
		return args -> {
			Stream.of("นาย", "นาง","นางสาว").forEach(name -> {
				Nametype nameType = new Nametype();
				nameType.setNametype(name);
				nametypeRepository.save(nameType);
			});

			Stream.of("ชาย", "หญิง").forEach(name -> {
				Gender gender = new Gender();
				gender.setGender(name);
				genderRepository.save(gender);
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
				province.setProvince(name);
				provinceRepository.save(province);
			});
			// Stream.of("ปรกติ", "เสียหาย").forEach(name -> {
			// 	Status status = new Status();
			// 	status.setName(name);
			// 	statusRepository.save(status);
			// });
			Stream.of("มือถือส่วนตัว", "โทรศัพท์บ้าน","อื่นๆ").forEach(name -> {
				Phonetype phonetype = new Phonetype();
				phonetype.setPhonetype(name);
				phonetypeRepository.save(phonetype);
			});

			Stream.of("พนักงานรักษาความปลอดภัย", "พนักงานประจําเคาน์เตอร์","พนักงานทําความสะอาด").forEach(name -> {
				Position position = new Position();
				position.setPosition(name);
				positionRepository.save(position);
			});
	
		Stream.of("กีฬากลางแจ้ง","กีฬาทางน้ำ","กีฬาในร่ม").forEach(name -> {
			Category category = new Category();
			category.setCategory(name);
			categoryRepository.save(category);
		});
		Stream.of("กรีฑา", "ว่ายน้ำ","ฟุตบอล","วอลเลย์บอล","เซปักตะกร้อ",
		"เทนนิส","เทเบิลเทนนิส","แบตมินตัน","วอลเลย์บอลชายหาด","เปตอง","ฟุตซอล").forEach(name -> {
			Sporttype sporttype = new Sporttype();
			sporttype.setSporttype(name);
			sporttypeRepository.save(sporttype);
		});
		
	
		Stream.of("สนามกรีฑา", "สนามว่ายน้ำ", "สนามฟุตบอล","สนามวอลเล่ย์บอล","สนามเซปักตะกร้อ",
		"สนามเทนนิส","สนามเทเบิลเทนนิส","สนามแบตนิสตัน","สนามเปตอง","สนามวอลเล่ย์บอลชายหาด","สนามฟุตซอล").forEach(name -> {
				Fieldtype fieldtype = new Fieldtype(); 
				fieldtype.setName(name); 
				fieldtypeRepository.save(fieldtype); 
			});
			Stream.of("แข่งขัน", "ปกติ").forEach(name -> {
				Fielduse fielduse = new Fielduse(); 
				fielduse.setName(name); 
				fielduseRepository.save(fielduse); 
			});
			AdminID adminID = new AdminID();	
			adminID.setAdminID("admin");
			adminID.setAdminpass("12341234");
		adminIDRepository.save(adminID);


			

			fieldtypeRepository.findAll().forEach(System.out::println); 
			fielduseRepository.findAll().forEach(System.out::println);
		
			genderRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Customer บน Terminal
			provinceRepository.findAll().forEach(System.out::println); 
			nametypeRepository.findAll().forEach(System.out::println);
			positionRepository.findAll().forEach(System.out::println);	
			phonetypeRepository.findAll().forEach(System.out::println);
			categoryRepository.findAll().forEach(System.out::println);
			sporttypeRepository.findAll().forEach(System.out::println);

		};
	}

}
