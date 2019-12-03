<template>
  <v-container>
    <v-card 
  max-width="900"
  leaght 
  class="mx-auto"
>
    <v-system-bar color="green"></v-system-bar>
    <v-row justify="center">
      <v-toolbar-title ><h1>ฝากประวัติ (Resume)</h1></v-toolbar-title>
    </v-row>
    <v-row>
    <v-col cols="20">
    <v-form>
            <v-row justify="center" style = "height: 65px;">      
            <!-- คำนำหน้า -->
            <v-col cols="6">
              <v-text-field
                solo
                label="ชื่อ-นามสกุล"
                v-model="name"
                :rules="[(v) => !!v || 'This field is required']"
                required
                prepend-icon="mdi-account"
                readonly
              ></v-text-field>
            </v-col> 

            <!-- ชื่อ-นามสกุล -->
            <v-col cols="4">
              <v-text-field
                solo
                label="โทรศัพท์ติดต่อ"
                v-model="phone"
                :rules="[(v) => !!v || 'This field is required']"
                required
                prepend-icon="mdi-phone"
                readonly
              ></v-text-field>
            </v-col>    
          </v-row>

        <v-row justify="center" style = "height: 70px;">
           <v-col cols="5" sm="4" md="4">
      <v-menu
        ref="menu"
        v-model="menu"
        :close-on-content-click="false"
        :return-value.sync="date"
        transition="scale-transition"
        offset-y
        min-width="290px"
      >
        <template v-slot:activator="{ on }">
          <v-text-field
            v-model="date"
            label="วัน-เดือน-ปีเกิด"
            prepend-icon="mdi-calendar"
            readonly
            v-on="on"
          ></v-text-field>
        </template>
        <v-date-picker v-model="date" no-title scrollable>
          <div class="flex-grow-1"></div>
          <v-btn text color="primary" @click="menu = false">Cancel</v-btn>
          <v-btn text color="primary" @click="$refs.menu.save(date)">OK</v-btn>
        </v-date-picker>
      </v-menu>
    </v-col>
            </v-row>


    <v-row justify="center" style = "height: 75px;">
            <!-- ที่อยู่ปัจจุบัน -->
            <v-col cols="8">
              <v-text-field
                solo
                label="ที่อยู่ปัจจุบัน"
                v-model="address"
                :rules="[(v) => !!v || 'This field is required']"
                clearable
                prepend-icon="mdi-home-outline"
              ></v-text-field>
            </v-col>    
          </v-row>

    <v-row justify="center" style = "height: 70px;">
            <!-- ระดับการศึกษา -->
              <v-col cols="4">
                <v-select
                  label="ระดับการศึกษา"
                  solo
                  v-model="resume.educationId"
                  :items="educations"
                  item-text="education_level"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                ></v-select>
              </v-col>
            </v-row>
            
            <v-row justify="center" style = "height: 80px;">
            <!-- สถานศึกษา -->
            <v-col cols="6">
              <v-text-field
                solo
                label="สถานศึกษา"
                v-model="university"
                :rules="[(v) => !!v || 'This field is required']"
                required
                clearable
                prepend-icon="mdi-book-open-page-variant"
              ></v-text-field>
            </v-col> 
            <!-- จังหวัด -->
            <v-col cols="4">
              <v-select
                label="จังหวัด"
                solo
                v-model="resume.provinceId"
                :items="provinces"
                item-text="province"
                item-value="id"
                :rules="[(v) => !!v || 'Item is required']"
                required
              ></v-select>
            </v-col>
          </v-row>

      <v-row justify="center" style = "height: 90px;">
            <!-- ประสบการณ์การทำงาน -->
              <v-col cols="3">
                <v-select
                  label="ประสบการณ์การทำงาน"
                  solo
                  v-model="resume.workexperienceId"
                  :items="workexperiences"
                  item-text="timework"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                ></v-select>
              </v-col>

            <!-- สถานประกอบการ -->
            <v-col cols="5">
              <v-text-field
                solo
                label="สถานประกอบการ"
                v-model="workaddress"
                :rules="[(v) => !!v || 'This field is required']"
                required
                clearable
                prepend-icon="mdi-map-marker-radius"
              ></v-text-field>
            </v-col>
            </v-row>

            <v-row justify="center" style = "height: 80px;">
            <!-- ความสามารถ/ทักษะ -->
            <v-col cols="7">
              <v-text-field
                solo
                label="ความสามารถ/ทักษะ"
                v-model="talent"
                :rules="[(v) => !!v || 'This field is required']"
                required
                clearable
                prepend-icon="mdi-google-controller"
              ></v-text-field>
            </v-col>    
          </v-row>

            <v-row justify="center" style = "height: 80px;">
            <!-- ความสนใจด้านต่างๆ -->
            <v-col cols="7">
              <v-text-field
                solo
                label="ความสนใจด้านต่างๆ"
                v-model="interest"
                :rules="[(v) => !!v || 'This field is required']"
                required
                clearable
                prepend-icon="mdi-creation"
              ></v-text-field>
            </v-col>    
          </v-row>
            
          

          <v-row justify="center" style = "height: 50px;">
            <v-col cols="12">
              <v-btn style="margin-left: 35%;" @click="saveData">save</v-btn>
              <v-btn style="margin-left: 10%;" @click="clear">clear</v-btn>
            </v-col>
          </v-row>

        </v-form>
      </v-col>
    </v-row>
    <v-system-bar color="green"></v-system-bar>
    
  </v-card>
    <v-col cols="12">
          <v-btn  x-large
            color = 'blue'
            style="margin-left: 79%;" 
            dark @click="back">BACK</v-btn>   
    </v-col>
  </v-container>
</template>

<script>
import http from "../http-common";

export default {
  name: "resume",
  data() {
    return {
      resume: {
        userId: [],
        educationId: null,
        provinceId: null,
        workexperienceId: null,

      },
        address : null,
        menu : '',
        date : null,
        interest : null,  
        talent : null,
        university : null,
        workaddress : null,
        educations : null,
        provinces : null,
        workexperiences : null,
        phone: localStorage.getItem('phone'),
        name: localStorage.getItem('name'),
    };
  },
  methods: {
    // ดึงข้อมูล User ใส่ combobox
    getUsers() {
      http
        .get("/user")
        .then(response => {
          this.users = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

      // ดึงข้อมูล Education ใส่ combobox
    getEducations() {
      http
        .get("/education")
        .then(response => {
          this.educations = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
        // ดึงข้อมูล Province ใส่ combobox
    getProvinces() {
      http
        .get("/province")
        .then(response => {
          this.provinces = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    // ดึงข้อมูล Workexperience ใส่ combobox
    getWorkexperiences() {
      http
        .get("/workexperience")
        .then(response => {
          this.workexperiences = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
  
  
    // function เมื่อกดปุ่ม save
   saveData() {
      http
        .post(
          "/resume/" +
          localStorage.getItem('id') +
            "/" +
            this.address +
            "/" +
            this.date +
            "/" +
            this.interest +
            "/" +
            this.talent +
            "/" +
            this.university +
            "/" +
            this.workaddress +
            "/" +   
            this.resume.educationId +
            "/" +
            this.resume.provinceId +
            "/" +
            this.resume.workexperienceId,
            this.resume
        )
        .then(response => {
        
          console.log(response);
          alert("บันทึกข้อมูลสำเร็จ");  
        })
    .catch(e => {
          console.log(e);
          alert("บันทึกข้อมูลไม่สำเร็จ");
        });

    },
    clear() {
    //this.$refs.form.reset();
      this.address = '';
      this.date = '';
      this.name = '';
      this.phone = '';
      this.education = '';
      this.province = '';
      this.university = '';
      this.workexperience = '';
      this.workaddress = '';
      this.talent = '';
      this.interest= '';
      this.resume.userId = null;
      this.resume.educationId = null;
      this.resume.provinceId = null;
      this.resume.workexperienceId = null;
    },
    back(){
        this.$router.push("/userchoice");
    },
    refreshList() {
     
      this.getEducations();
      this.getProvinces();
      this.getWorkexperiences();
    }
    /* eslint-enable no-console */
  },
    mounted() {
     
      this.getEducations();
      this.getProvinces();
      this.getWorkexperiences();
  }
};
</script>
