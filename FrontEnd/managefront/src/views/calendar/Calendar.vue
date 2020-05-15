<template>
  <div id="Calendar_box">
    <div id="Calendar">
      <span id="top_h1"><h1>社团日历</h1></span>
      <el-calendar style="background-color:	#FFFAF0">
        <template
          slot="dateCell"
          slot-scope="{date, data}">
          <p>
            {{ data.day.split('-').slice(2).join('-') }}<br /> {{dealMyDate(data.day)}}
          </p>
        </template>
      </el-calendar>
    </div>
  </div>
</template>

<script>
    import moment from 'moment'
    export default {
        name: "Calendar",
        data() {
            return {
                resDate: [
                ],
                value: new Date()
            }
        },
        methods: {
            dateFormat(value){
                let date = value
                if (date == undefined) {
                    return ''
                }
                return moment(date).format("YYYY-MM-DD")
            },

            dealMyDate(v) {
                let len = this.resDate.length
                let res = ""
                for(let i=0; i<len; i++){
                    if(moment(this.resDate[i].date).format("YYYY-MM-DD") === v) {
                        res = this.resDate[i].content
                        break
                    }
                }
                return res
            }
        },
        created() {
            const _this = this;
            this.$axios.post("/CalendarFind")
                .then(function (response) {
                    if (response.data.code == 1) {
                        console.log(response.data.msg)
                    }
                    if (response.data.code == 0) {
                        let Date = response.data.data.resDate
                        _this.resDate = Date
                    }
                })
                .catch(function (error) {
                    console.log(error)
                });
        }
    }
</script>

<style>
  #Calendar {
    width: 100%;
    margin-top: 10px;
  }

  #top_h1 {
    color: 	#1E90FF;
    font-family:STHupo;
  }

  #Calendar_box {
    height: 400px;
    width: 60%;
    margin: auto;
  }

</style>
