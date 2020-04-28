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
    export default {
        name: "Calendar",
        data() {
            return {
                resDate: [
                    {date:"2020-04-18",content:"篮球赛"},
                    {date:"2020-04-19",content:"摄影大赛"},
                    {date:"2020-04-11",content:"校园十大歌手"}
                ],
                value: new Date()
            }
        },
        methods: {
            dealMyDate(v) {
                console.log(v)
                let len = this.resDate.length
                let res = ""
                for(let i=0; i<len; i++){
                    if(this.resDate[i].date == v) {
                        res = this.resDate[i].content
                        break
                    }
                }
                return res
            }
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
