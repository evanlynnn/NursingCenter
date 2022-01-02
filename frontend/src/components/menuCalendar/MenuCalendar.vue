<template>
  <div>

    <el-card class="box-card">
      <!--Top Toolbar-->
      <div slot="header" class="clearfix">
        <span>膳食日历</span>
      </div>

      <!--Content-->
      <DayMenu title="星期一" :menu-list="menuListSorted[0]"/>
      <DayMenu title="星期二" :menu-list="menuListSorted[1]"/>
      <DayMenu title="星期三" :menu-list="menuListSorted[2]"/>
      <DayMenu title="星期四" :menu-list="menuListSorted[3]"/>
      <DayMenu title="星期五" :menu-list="menuListSorted[4]"/>
      <DayMenu title="星期六" :menu-list="menuListSorted[5]"/>
      <DayMenu title="星期七" :menu-list="menuListSorted[6]"/>

    </el-card>

  </div>
</template>

<script>
import axios from "axios";
import DayMenu from "./DayMenu";

export default {
  name: "MenuCalendar",
  props: ['userId'],
  components: {DayMenu},
  data() {
    return {
      queryForm: {
        user: {},
      },
      menuList: {},
      menuListSorted: {},
    }
  },
  created() {
    console.log('userId:', this.userId)
    axios.get('http://localhost:8081/user/sel/' + this.userId)
        .then((response) => {
          this.queryForm.user = response.data
          console.log(this.queryForm.user)
          axios.post('http://localhost:8081/foodMenu/query', this.queryForm)
              .then((response) => {
                this.menuList = response.data
                console.log(this.menuList)
                this.menuListSorted = this.groupBy(this.menuList, function (menu) {
                  return menu.week;
                });
                console.log(this.menuListSorted)
              })
        }).then(err => console.log(err))
  },
  methods: {
    groupBy(array, f) {
      let groups = {};
      array.forEach(function (o) {
        let group = JSON.stringify(f(o));
        groups[group] = groups[group] || [];
        groups[group].push(o);
      });
      return Object.keys(groups).map(function (group) {
        return groups[group];
      });
    }
  }
}
</script>

<style scoped>

</style>