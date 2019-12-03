<template>
    <div>
        <v-row align="center">
            <v-col class="text-center">
                <font><p class="text-center font-weight-black display-4 ">ยินดีต้อนรับ</p></font><p></p>

            </v-col>
        </v-row>

        <v-row align="center">
            <v-col class="text-center" >
            <v-card
                max-width="600"
                height="450"
                class="mx-auto"
                color ="#F5F5F5"
                elevation="20"
            >
                <v-row align="center">
                    <v-col class="text-center">
                        <p></p><font><p class="text-center font-weight-black display-2 ">ผู้สมัครงาน</p></font><p></p><br>
                        <img src="..\assets\user.png" style="width:200px;height:200px;">
                    </v-col>
                </v-row>
                <v-row align="center">
                    <v-col class="text-center" cols="30">
                        <v-btn x-large color="green" dark @click="userlogin">ล็อกอิน</v-btn>
                    </v-col>
                </v-row>
            </v-card>
            </v-col>

            <v-col class="text-center" >
            <v-card
                max-width="600"
                height="450"
                class="mx-auto"
                color ="#F5F5F5"
                elevation="20"
            >
                <v-row align="center">
                    <v-col class="text-center">
                       <p></p><font><p class="text-center font-weight-black display-2 ">ผู้ประกอบการ</p></font><p></p><br>
                       <img src="..\assets\company.png" style="width:200px;height:200px;">
                    </v-col>
                </v-row>
                
                <v-row align="center">
                    <!-- <v-col class="text-center" cols="30"> 
                        <v-btn x-large color="green" dark @click="userlogin">ผู้สมัครงาน</v-btn>
                    </v-col>-->
                    <v-col class="text-center" cols="30">
                        <v-btn x-large color="pink" dark @click="companylogin">ล็อกอิน</v-btn>
                    </v-col>
                </v-row>
  
            </v-card>
            </v-col>
        </v-row>
</div>

</template>

<script>
export default {

methods: {
    userlogin(){
        this.$router.push("/registeruser/login");
    },
    companylogin(){
        this.$router.push("/registercompany/login");
    }
}
}
</script>
