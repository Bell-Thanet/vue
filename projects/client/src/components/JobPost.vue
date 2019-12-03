<template>
  <v-container>
<v-card 
  max-width="850"
  class="mx-auto"
 >
<v-system-bar color="pink"></v-system-bar>
<v-system-bar color="pink"></v-system-bar>
<v-row justify="center">
<v-toolbar-title ><h1>ใบประกาศรับสมัครงาน</h1></v-toolbar-title>
</v-row>
    <v-row justify="center">
      <v-col cols="7">
        <v-form >
           <!-- company-->
            <v-row justify="center">
               
<v-col cols="6">
              <v-text-field
              readonly
                solo
                
                label="บริษัท"
                v-model= "company"
                :rules="[(v) => !!v || 'This field is required']"
                required
                
               prepend-icon= "mdi-home-modern"
              ></v-text-field>
            </v-col>



             
            </v-row>
             <!-- ตำแหน่งงาน-->
            <v-row justify="center">
              <v-col cols="7">
                <v-select
                  label="ตำแหน่งงาน"
                  solo
                  v-model="JobPost.positionId"
                  :items="positions"
                  item-text="position"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                ></v-select>
              </v-col>
            </v-row>



              <!-- ระดับการศึกษา-->
              <v-row justify="center">
            <v-col cols="6">
              <v-text-field
                solo
                label="ระดับการศึกษา"
                v-model= "educationlevel"
                :rules="[(v) => !!v || 'This field is required']"
                required
                clearable
                prepend-icon="mdi-school"
              ></v-text-field>
            </v-col>

            <v-col cols="6">
              <v-text-field
                solo
                label="เงินเดือน"
                v-model= "salary"
                :rules="[(v) => !!v || 'This field is required']"
                required
                clearable
                prepend-icon="mdi-cash-multiple"
              ></v-text-field>
            </v-col>
          </v-row>
                <!-- สวัสดิการ-->
              <v-row justify="center">
              <v-col cols="7">
                <v-select
                  label="สวัสดิการ"
                  solo
                  v-model="JobPost.BenefitsId"
                  :items="Benefits"
                  item-text="benefits"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                ></v-select>
              </v-col>
            </v-row>

          <!-- text area-->
          <v-row justify="center">
          <v-col cols="12"  md="8" >
        <v-textarea
        rows="2"
          solo
          name="other_detial"
          label="รายละเอียดอื่นๆ"
           v-model= "Other_details"
        ></v-textarea>
      </v-col>
     </v-row>

 
          <v-row justify="center">
            <v-col cols="12">
              <v-btn 
                style="margin-left: 25%;"
                @click="clear">clear
              </v-btn>
              <v-btn 
                style="margin-left: 30%;"
                @click="saveData">save
              </v-btn>
            </v-col>
          </v-row>

        </v-form>
      </v-col>
    </v-row>


<v-system-bar color="pink"></v-system-bar>
<v-system-bar color="pink"></v-system-bar>

      </v-card>
      <v-col cols="12">
          <v-btn  x-large
            color = 'blue'
            style="margin-left: 77%;" 
            dark @click="back">BACK</v-btn>   
      </v-col>
  </v-container>
  
</template>

<script>
import http from "../http-common";

export default {
  name: "JobPost",

  data() {
    return {
      JobPost: {
        positionId: null,
        BenefitsId: null,
      },
     
        salary : '',
        educationlevel : '',
        Other_details : '',
        company : localStorage.getItem('name'), 
        positions : null,
        Benefits : null
      
    };
    var firsKey = localStorage.key(0); 
  console.log(firstKey); 
  },
  methods: {
    
  // ดึงข้อมูล NameType ใส่ combobox
    getPositions() {
      http
        .get("/position")
        .then(response => {
          this.positions = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
        // ดึงข้อมูล PhoneType ใส่ combobox
    getBenefits() {
      http
        .get("/benefits")
        .then(response => {
          this.Benefits = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
  
  
    // function เมื่อกดปุ่ม submit
   saveData() {
      http
        .post(
          "/JobPost/" + localStorage.getItem('id') +
           "/" + this.JobPost.positionId + 
           "/" + this.educationlevel + 
           "/" + this.salary +
            "/" + this.JobPost.BenefitsId  + 
            "/" + this.Other_details,
            this.JobPost
          
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
     
        this.salary = '';
        this.educationlevel = '';
        this.Other_details = '';
  
       
        this.JobPost.positionId = null;
        this.JobPost.BenefitsId = null;
    },
    refreshList() {
    
      this.getPositions();
      this.getBenefits();
      
    },
    back(){
    this.$router.push("/companychoice");
    }

  },
    mounted() {
    
      this.getPositions();
      this.getBenefits();
  }
};
</script>
