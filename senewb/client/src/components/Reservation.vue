﻿<template>
    <v-container>
   
  
  <v-navigation-drawer
      absolute
      dark
      src="https://c.wallhere.com/photos/e4/53/1920x1080_px_anime_Der_Wanderer_ber_Dem_Nebelmeer_nature_sky_sunset-609196.jpg!d"
      width="100%"
      permanent
    ><br>
 <v-card
    class="mx-auto"
    max-width="1300"
    color = "#8B636C"
  >
  
<v-system-bar color=#CD919E></v-system-bar>
<v-system-bar color=#CD919E></v-system-bar>
     <v-spacer></v-spacer>
      <v-row justify="center">
        <v-toolbar-title>
          <h1>ระบบจองเข้าใช้สถานกีฬา</h1>
        </v-toolbar-title>
      </v-row>
      <v-spacer></v-spacer>

      <v-row justify="center">
          <v-col cols="6">
       <v-row justify="center">
       <v-col cols="15" sm="3" md="5">
          <v-text-field
            label="ID ผู้ใช้งาน"
            v-model="reservation.member_id"
            outlined
          ></v-text-field>
          <p v-if="memberCheck != ''">Member Name : {{name}} </p>
        </v-col>
         <v-col cols="2">
            <div class="my-2">
          <v-btn @click="ShowMember_id" depressed large color="primary">Search</v-btn>
         </div>
         </v-col>
       </v-row>
       
       <div v-if="memberCheck">
        <v-row justify="center">
         <v-col cols="20" >
          <v-select
           solo
          :items="fieldtypes"
          v-model="reservation.fieldtype"
          item-text="fieldtype_name"
          item-value="id"
          label="ประเภทสนามกีฬา"
          :rules="[(v) => !!v || 'Item is required']"
           required
          ></v-select>
        </v-col>
      </v-row>
      
      <v-row justify="center">
        <v-col cols="20" >
           <v-select
                solo
          label="ประเภทการใช้งานสนามกีฬา"
          v-model="reservation.fielduse"
          :items="fielduses"
          item-text="fielduse_name"
          item-value="id"
            :rules="[(v) => !!v || 'Item is required']"
                    required

          ></v-select>
        </v-col>
      </v-row>
      <v-row justify="center">
                <v-col cols="25">
                  <v-text-field
                solo
                label="ชื่อพนักงาน"
                v-model="nameemp"
                :rules="[(v) => !!v || 'This field is required']"
                required
                prepend-icon="mdi-account"
                readonly
              ></v-text-field>
                </v-col>
              </v-row>

      <v-row justify="center">
      <v-col cols="20" sm="3" md="6">
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
            v-model="reservation.date"
            label="ระบุวันจองสนามกีฬา"
            prepend-icon="mdi-calendar"
            readonly
            v-on="on"
          ></v-text-field>
        </template>
        <v-date-picker v-model="reservation.date" no-title scrollable>
          <div class="flex-grow-1"></div>
          <v-btn text color="primary" @click="menu = false">Cancel</v-btn>
          <v-btn text color="primary" @click="$refs.menu.save(date)">OK</v-btn>
        </v-date-picker>
      </v-menu>
    </v-col>
    </v-row>




 <v-row>
    <v-time-picker
      
      v-model="reservation.start_time"
      use-seconds
    > <font>เวลาเข้า</font></v-time-picker>

    <v-time-picker
      v-model="reservation.end_time" 
      use-seconds
    >
    <font>เวลาออก</font>
    </v-time-picker>
  </v-row>
 

   
      <v-row justify="center"> <v-spacer></v-spacer>
       <div class="my-5">
          <v-btn @click="saveReservation" color="pink">บันทึก</v-btn>
         </div>
     <v-spacer></v-spacer>
      </v-row>
      <v-col cols="3">
      <v-btn x-medium color="#6C7B8B" style="margin-left: 380%;" dark @click="back">Back</v-btn>
    </v-col>
       </div>
         </v-col>
      </v-row>
       <v-system-bar color="#CD919E"></v-system-bar>
        <v-system-bar color="#CD919E"></v-system-bar>

   </v-card>
  </v-navigation-drawer>
  </v-container>
</template>


<script>
import http from "../http-common";
export default {
  name: "reservation",
  data() {
    return {
      reservation: {
        fieldtype: null,
        fielduse: null,
        employee: null,
        member_id: null
      },
      date: null, 
      start_time: null,
      end_time: null,
      memberCheck: false,
      name: "",
      fieldtypes: null,
      fielduses: [],
      employees: [],
       nameemp: localStorage.getItem('name'),
    };
  },
  methods: {
    getEmployees() {
      http
        .get("/Employee")
        .then(response => {
          this.employees = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    getFieldtypes() {
      http
        .get("/fieldtype")
        .then(response => {
          this.fieldtypes = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    
    getFielduses() {
      http
        .get("/fielduse")
        .then(response => {
          this.fielduses = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    ShowMember_id(){
      http
      .get("/Members/" + this.reservation.member_id)
      .then(response => {
        console.log(response);
        if(response.data != null){
          this.name = response.data.name;
          this.memberCheck = response.status;
          alert("พบผู้ใช้งาน");
          } else {
            this.returns.genderId = "";
            alert("ไม่พบผู้ใช้งาน");
          }
      })
      .catch(e => {
        console.log(e);
      });
      this.submitted = true;
    },
    
    saveReservation() {
       
      http
        .post(
          "/reservation/" +
            this.reservation.member_id +
            "/" +
            this.reservation.fieldtype +
            "/" +
            this.reservation.fielduse +
            "/"+
            
            this.reservation.start_time +
            "/" +
            this.reservation.end_time +
            "/" +
            this.reservation.date +
            "/" +
             localStorage.getItem('emp_id'),
             this.reservation
         )
        .then(response => {
        
          console.log(response);
          alert("บันทึกสำเร็จ");  
        })
    .catch(e => {
          console.log(e);
          alert("บันทึกไม่สำเร็จ");  
        });  
    
  },
    //clear() {
      //this.$refs.form.reset();
       // this.addjob.name = "";
       // this.addjob.user = "";
       // this.addjob.phone = "";
        //this.addjob.education = "";
        //this.addjob.jobPost = "";
        //this.addjob.information = "";
        //this.addjob.introduction = "";
    //},
    back() {
      this.$router.push("/Employeemenu");
    },
    refreshList() {
      this.getEmployees();
      
      this.getFieldtypes();
      this.getFielduses();
    }   
  },
  mounted() {
    this.getEmployees();
      
      this.getFieldtypes();
      this.getFielduses();
  }
};
</script>