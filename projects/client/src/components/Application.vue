<template>
  <v-container>
    <v-card max-width="900" class="mx-auto">
      <v-system-bar color="green"></v-system-bar>
      <v-system-bar color="green"></v-system-bar>
      <v-row justify="center">
        <v-toolbar-title>
          <h1>ใบสมัครงาน</h1>
        </v-toolbar-title>
      </v-row>

      <v-row>
        <v-col cols="15">
          <v-form>
            <v-row style="height: 75px;" justify="center">
              <!-- ชื่อ-นามสกุล -->
              <v-col cols="3">
                <v-text-field
                  solo
                  label="ชื่อ-นามสกุล"
                  v-model="name"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                  prepend-icon="mdi-account"
                  readonly
                ></v-text-field>
              </v-col>

              <!-- เลขบัตรประชาชน -->
              <v-col cols="4">
                <v-text-field
                  label="เลขบัตรประชาชน"
                  solo
                  v-model="cardId"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                ></v-text-field>
              </v-col>
            </v-row>

            <v-row style="height: 75px;" justify="center">
              <!-- ตำแหน่ง -->
              <v-col cols="3">
                <v-select
                  label="ตำแหน่ง"
                  solo
                  v-model="application.jobPostId"
                  :items="jobPosts"
                  item-text="position.position"
                  item-value="jobPost_id"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                  prepend-icon="mdi-worker"
                ></v-select>
              </v-col>
            </v-row>

            <v-row style="height: 75px;" justify="center">
              <!-- e-mail -->
              <v-col cols="3">
                <v-text-field
                  solo
                  label="email"
                  v-model="email"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                  prepend-icon="mdi-email"
                  readonly
                ></v-text-field>
              </v-col>

              <!-- เบอร์โทร -->
              <v-col cols="3">
                <v-text-field
                  solo
                  label="เบอร์โทร"
                  v-model="phone"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                  prepend-icon="mdi-phone"
                  readonly
                ></v-text-field>
              </v-col>
            </v-row>

            <v-row style="height: 150px;" justify="center">
              <!-- แนะนำตัวเอง -->
              <v-col cols="2" md="8">
                <v-textarea
                  label="แนะนำตัวเอง"
                  solo
                  v-model="introduction"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                ></v-textarea>
              </v-col>
            </v-row>

            <v-row style="height: 75px;" justify="center">
              <!-- ช่องทางการทราบข่าวสาร -->
              <v-col cols="3">
                <v-select
                  solo
                  label="ช่องทางการทราบข่าวสาร"
                  v-model="application.sourceId"
                  :items="sources"
                  item-text="sourceType"
                  item-value="id"
                  :rules="[(v) => !!v || 'This field is required']"
                  required
                ></v-select>
              </v-col>
            </v-row>

            <v-row style="height: 75px;" justify="center">
              <v-col cols="12">
                <v-btn style="margin-left: 45%;" @click="saveData">save</v-btn>
              </v-col>
            </v-row>
          </v-form>
        </v-col>
      </v-row>
      <v-system-bar color="green"></v-system-bar>
      <v-system-bar color="green"></v-system-bar>
    </v-card>
    <v-col cols="12">
      <v-btn x-large color="blue" style="margin-left: 79%;" dark @click="back">BACK</v-btn>
    </v-col>
  </v-container>
</template>

<script>
import http from "../http-common";

export default {
  name: "application",
  data() {
    return {
      application: {
        jobPostId: "",
        sourceId: ""
      },
      cardId: "",
      introduction: "",
      jobPosts: "",
      sources: '',
      position: [],
      email: localStorage.getItem("email"),
      phone: localStorage.getItem("phone"),
      name: localStorage.getItem("name")
    };
  },
  methods: {

    getJobPosts() {
      http
        .get("/JobPost")
        .then(response => {
          this.jobPosts = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    getSources() {
      http
        .get("/source")
        .then(response => {
          this.sources = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    saveData() {

      http
        .post(
          "/Application/" +
            localStorage.getItem("id") +
            "/" +
            this.cardId +
            "/" +
            this.application.jobPostId +
            "/" +
            this.introduction +
            "/" +
            this.application.sourceId,
          this.application
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
    back() {
      this.$router.push("/userchoice");
    }
  },
  mounted() {
    this.getJobPosts();
    this.getSources();
  }
};
</script>