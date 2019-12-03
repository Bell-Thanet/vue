<template>
  <v-container>
    <v-card 
  max-width="900"
  class="mx-auto"
  >
  <v-system-bar color="pink"></v-system-bar>
<v-system-bar color="pink"></v-system-bar>
<v-row justify="center">
      <v-toolbar-title ><h1>ใบนัดสัมภาษณ์</h1></v-toolbar-title>
    </v-row>
 <v-row justify="center">
      <v-col cols="9">
        <v-form >
            <!-- บริษัท -->
            <v-row justify="center">
              <v-col cols="3">
                <v-text-field
                  solo
                  label="บริษัท"
                  v-model="company"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                 
                  readonly
                ></v-text-field>
              </v-col>   
            </v-row>

     <v-row justify="center">
            <!-- ชื่อ-สกุล -->
            <v-col cols="4">
              <v-select
                label="ชื่อ-สกุล"
                solo
                v-model="interview.application"
                :items="application"
                item-text="user.name"
                item-value="id"
                :rules="[(v) => !!v || 'Item is required']"
                prepend-icon="mdi-account-multiple"
                required
              ></v-select>
              </v-col>
            </v-row>

   
    
            <v-row justify="center">
            <!-- ตำแหน่งงาน -->
            <v-col cols="4">
              <v-select
                label="ตำแหน่งงาน"
                solo
                v-model="interview.application"
                :items="application"
                item-text="post.position.position"
                item-value="id"
                :rules="[(v) => !!v || 'Item is required']"
                prepend-icon="mdi-worker"
                required
              ></v-select>
              </v-col>
            </v-row>

             <v-row justify="center">
            <!-- จังหวัด -->
            <v-col cols="4">
              <v-select
                label="จังหวัด"
                solo
                v-model="interview.province"
                :items="province"
                item-text="province"
                item-value="id"
                :rules="[(v) => !!v || 'Item is required']"
                prepend-icon="mdi-map-marker-radius"
                required
              ></v-select>
              </v-col>
            </v-row>

           <!-- วันที่นัดสัมภาษณ์ -->
           
           <v-row justify="center">
           <v-col cols="12" sm="6" md="4">
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
            label="ระบุวันนัดสัมภาษณ์"
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

          <v-row justify="center">
            <v-col cols="12">
              <v-btn 
                style="margin-left: 45%;"
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
  name: "interview",
  data() {
    return {
      interview: {
        application: '',
        company: '',
        province: '',
      },
        application : '',
        company : localStorage.getItem('name'),
        date: '',
        menu: '',
        province :''
    };
  },
  methods: {
  // ดึงข้อมูล NameType ใส่ combobox
    getApplication() {
      http
        .get("/Application")
        .then(response => {
          this.application = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
       
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
  
    // function เมื่อกดปุ่ม submit
   saveData() {
      http
        .post(
          "/interview/" + 
            this.interview.application +
            "/" +
            this.interview.application +
            "/" +
            localStorage.getItem('id') +
            "/" +
            this.date + 
            "/" +
            this.interview.province,
            this.interview
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
    refreshList() {
     
      this.getApplication();
      this.getProvince();
    },
    back(){
    this.$router.push("/companychoice");
    }

    /* eslint-enable no-console */
  },
    mounted() {

      this.getApplication();
      this.getProvince();
  }
};
</script>