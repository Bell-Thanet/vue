<template>
  <v-container>
    <v-card 
  max-width="900"
  class="mx-auto"
>
<v-system-bar color="pink"></v-system-bar>
<v-system-bar color="pink"></v-system-bar>
<v-row justify="center">
<v-toolbar-title ><h1>Register</h1></v-toolbar-title>
</v-row>
    <v-row justify="center">
      <v-col cols="10">
        <v-form >
          <v-row justify="center">  
            <!-- ชื่อ- ผู้ประกอบการ -->
            <v-col cols="8">
              <v-text-field
                solo  
                label="ชื่อ-ผู้ประกอบการ"
                v-model= "name"
                :rules="[(v) => !!v || 'This field is required']"
                required
                clearable
               prepend-icon= "mdi-home-modern"
              ></v-text-field>
            </v-col>
          </v-row>
          <v-row
          
           justify="center"> 
             <!-- ขนาดผู้ประกอบการ -->
            <v-col cols="5">
              <v-select
                label="ขนาด-ผู้ประกอบการ"
                solo
                v-model="Company.size"
                :items="size"
                item-text="size"
                item-value="id"
                :rules="[(v) => !!v || 'Item is required']"
                required
              ></v-select>
              <!-- ชนิดบริษัท -->
            </v-col>    
               <v-col cols="5">
              <v-select
                label="ประเภท-ผู้ประกอบการ"
                solo
                v-model="Company.type"
                :items="type"
                item-text="type"
                item-value="id"
                :rules="[(v) => !!v || 'Item is required']"
                required
              ></v-select>
              </v-col> 
          </v-row>
     <v-row justify="center"> 
             <!-- จังหวัดที่ตั่ง -->
            <v-col cols="5">
              <v-select
                label="จังหวัด"
                solo
                v-model="Company.province"
                :items="province"
                item-text="province"
                item-value="id"
                :rules="[(v) => !!v || 'Item is required']"
                required
              ></v-select>
               </v-col>
          </v-row>

           <!-- email -->
          <v-row justify="center">
            <v-col cols="8">
              <v-text-field
                solo
                label="Email"
                v-model= "email"
                :rules="[(v) => !!v || 'This field is required']"
                required
                clearable
                prepend-icon="mdi-email"
              ></v-text-field>
            </v-col>
          </v-row>

            <!-- password -->
          <v-row justify="center">
            <v-col cols="8">
              <v-text-field
                solo
                label="PASSWORD"
                v-model= "password"
                :append-icon="show1 ? 'mdi-eye' : 'mdi-eye-off'"
                :rules="[rules.required, rules.min]"
                :type="show1 ? 'text' : 'password'"
                hint="At least 8 characters"
                prepend-icon="mdi-lock"
                required
                counter
                clearable
                @click:append="show1 = !show1"
              ></v-text-field>
            </v-col>
          </v-row>
          
        <!-- ยืมยันpassword -->
          <v-row justify="center">
            <v-col cols="8">
              <v-text-field
                solo
                label="ยืนยัน PASSWORD"
                v-model= "repassword"
                :type="show2 ? 'text' : 'password'"
                :append-icon="show2 ?  'mdi-eye' : 'mdi-eye-off'"
                :rules="[rules.required,rules.checkpass]"
                hint="At least 8 characters"
                prepend-icon="mdi-lock"
                required
                counter
                clearable
                @click:append="show2 = !show2"
              ></v-text-field>
            </v-col>
          </v-row>
 
         <v-row justify="center" style = "height: 20px;">
            <v-col cols="15">
              <v-btn style="margin-left: 25%;" @click="saveData">save</v-btn>
              <v-btn style="margin-left:25%;" @click="BLogin">Login</v-btn>
            </v-col>
          </v-row>
           
        </v-form>
      </v-col>
    </v-row>
  <br>
<br>
<v-system-bar color="pink"></v-system-bar>
<v-system-bar color="pink"></v-system-bar>
  </v-card>
  </v-container>
  
</template>

<script>
import http from "../http-common";

export default {
  name: "Company",
  data() {
    return {
      Company: {
        type: null,
        size: null,
        province: null,
      },
        show1: false,
        show2: false,
        name : '',
        email : '',
        password : '',
        repassword : '',
        size: null,
        type: null,
        province: null,
      rules: {
          required: value => !!value || 'This field is required',
          min: v => v.length >= 8 || 'Min 8 characters',
          checkpass: () => this.repassword == this.password || 'Passwords do not match',
      }
      
    };
  },
  methods: {
    /* eslint-disable no-console */

    // ดึงข้อมูล size ใส่ combobox
    getSize() {
      http
        .get("/size")
        .then(response => {
          this.size = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
  // ดึงข้อมูล Type ใส่ combobox
    getType() {
      http
        .get("/type")
        .then(response => {
          this.type = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
        // ดึงข้อมูล province ใส่ combobox
    getProvince() {
      http
        .get("/province")
        .then(response => {
          this.province = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
   saveData() {
    if(this.password == this.repassword && this.password.length>=8 && this.repassword.length>=8 ){
      http
        .post(
          "/Company/" +
            this.name + 
            "/" +
            this.email +
            "/" +
            this.password +
            "/" +
            this.Company.size +
            "/" +
            this.Company.type +
            "/" +
            this.Company.province,
            this.Company
        )
        .then(response => {
          console.log(response);
            
        })
        .catch(e => {
          console.log(e);
        });
      this.submitted = true;
      this.$router.push("/registercompany/login");
      alert("สมัครสมาชิกสำเร็จ")
    }    
    else{  
      alert("สมัครสมาชิกไม่สำเร็จ")
    }
   
  },
   BLogin(){
    this.$router.push("/registercompany/login");
   }
  },
    mounted() {
      this.getSize();
      this.getType();
      this.getProvince();
  }
};
</script>
