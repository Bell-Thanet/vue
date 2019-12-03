<template>
  <v-container>
  <v-card 
    max-width="900"
    class="mx-auto"
  >
    <v-system-bar color="green"></v-system-bar>
    <v-system-bar color="green"></v-system-bar>
    <v-row justify="center">
      <v-toolbar-title ><h1>Register</h1></v-toolbar-title>
    </v-row>
    <v-row justify="center">
      <v-col cols="7">
        <v-form >
            <!-- เพศ -->
            <v-row justify="center">
              <v-col cols="4">
                <v-select
                  label="เพศ"
                  solo
                  v-model="user.genderId"
                  :items="genders"
                  item-text="sex"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                  prepend-icon="mdi-gender-male-female"
                ></v-select>
              </v-col>
            </v-row>
            
            
          <v-row justify="center">
            <!-- คำนำหน้า -->
            <v-col cols="4">
              <v-select
                label="คำนำหน้า"
                solo
                v-model="user.nametypeId"
                :items="nametypes"
                item-text="nametype"
                item-value="id"
                :rules="[(v) => !!v || 'Item is required']"
                required
                prepend-icon="mdi-account"
              ></v-select>
            </v-col>
            <!-- ชื่อ-นามสกุล -->
            <v-col cols="7">
              <v-text-field
                solo
                label="ชื่อ-นามสกุล"
                v-model= "name"
                :rules="[(v) => !!v || 'This field is required']"
                required
                clearable
              ></v-text-field>
            </v-col>    
          </v-row>

            <!-- ประเภทโทรศัพท์ --> 
          <v-row justify="center">
            <v-col cols="5">
              <v-select
                label="ประเภทโทรศัพท์"
                solo
                v-model="user.phonetypeId"
                :items="phonetypes"
                item-text="phonetype"
                item-value="id"
                :rules="[(v) => !!v || 'Item is required']"
                required
                prepend-icon="mdi-phone"
              ></v-select>
            </v-col>
            <!-- เบอร์โทรศัพย์ -->  
            <v-col cols="6">
              <v-text-field
                solo
                label="เบอร์โทรศัพท์"
                v-model= "phone"
                :rules="[rules.nphone, (v) => !!v || 'Item is required']"
                required
                clearable
              ></v-text-field>
            </v-col>
          </v-row>

           <!-- email -->
          <v-row justify="center">
            <v-col cols="10">
              <v-text-field
                solo
                label="Email"
                v-model= "email"
                :rules="emailRules"
                required
                clearable
                prepend-icon="mdi-email"
              ></v-text-field>
            </v-col>
          </v-row>

            <!-- password -->
          <v-row justify="center">
            <v-col cols="10">
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
            <v-col cols="10">
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
 
          <v-row justify="center">
            <v-col cols="12">
              <v-btn 
                style="margin-left: 20%;"
                @click="saveData">save
              </v-btn>
              <v-btn 
                style="margin-left: 30%;"
                @click="login">login
              </v-btn>
            </v-col>
          </v-row>

        </v-form>
      </v-col>
    </v-row>
    <v-system-bar color="green"></v-system-bar>
    <v-system-bar color="green"></v-system-bar>
  </v-card>
  </v-container>
  
</template>

<script>
import http from "../http-common";

export default {
  data() {
    return {
      user: {
        genderId: null,
        nametypeId: null,
        phonetypeId: null,
      },
        show1: false,
        show2: false,
        name : '',
        phone : '',
        email : '',
        password : '',
        repassword : '',
        genders : null,
        nametypes : null,
        phonetypes : null,
      rules: {
          required: value => !!value || 'This field is required',
          min: v => v.length >= 8 || 'Min 8 characters',
          checkpass: () => this.repassword == this.password || 'Passwords do not match',
          nphone: v => v.length <= 10 || 'Max 10 characters',
      },
      emailRules: [
      v => !!v || 'E-mail is required',
      v => /.+@.+\..+/.test(v) || 'E-mail must be valid',
      ],
    };
  },
  methods: {


    // ดึงข้อมูล Gender ใส่ combobox
    getGenders() {
      http
        .get("/gender")
        .then(response => {
          this.genders = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
  // ดึงข้อมูล NameType ใส่ combobox
    getNameTypes() {
      http
        .get("/nametype")
        .then(response => {
          this.nametypes = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
        // ดึงข้อมูล PhoneType ใส่ combobox
    getPhoneTypes() {
      http
        .get("/phonetype")
        .then(response => {
          this.phonetypes = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
  
   saveData() {
    if((this.password == this.repassword) && (this.password.length>=8 || this.repassword.length>=8)){
      http
        .post(
          "/User/" + this.name + "/" + this.email + "/" + this.password + "/" + this.phone + "/" + this.user.genderId + "/" 
          + this.user.nametypeId +"/" + this.user.phonetypeId
        ).then(response => {
          console.log(response);
          alert("บันทึกข้อมูลสำเร็จ");  
          this.$router.push("/registeruser/login");
        })
        .catch(e => {
          console.log(e);
          alert("บันทึกไม่สำเร็จ");
        });
      
    }else{
      alert("บันทึกไม่สำเร็จ");
    }
 
  },
    login() {
        this.$router.push("/registeruser/login");
    },
  },
    mounted() {
      this.getGenders();
      this.getNameTypes();
      this.getPhoneTypes();
  },

};
</script>
