(function(e){function t(t){for(var r,o,c=t[0],u=t[1],l=t[2],s=0,d=[];s<c.length;s++)o=c[s],Object.prototype.hasOwnProperty.call(a,o)&&a[o]&&d.push(a[o][0]),a[o]=0;for(r in u)Object.prototype.hasOwnProperty.call(u,r)&&(e[r]=u[r]);f&&f(t);while(d.length)d.shift()();return i.push.apply(i,l||[]),n()}function n(){for(var e,t=0;t<i.length;t++){for(var n=i[t],r=!0,o=1;o<n.length;o++){var c=n[o];0!==a[c]&&(r=!1)}r&&(i.splice(t--,1),e=u(u.s=n[0]))}return e}var r={},o={app:0},a={app:0},i=[];function c(e){return u.p+"static/js/"+({about:"about",galerie:"galerie"}[e]||e)+"."+{about:"867db854",galerie:"f73859f1"}[e]+".js"}function u(t){if(r[t])return r[t].exports;var n=r[t]={i:t,l:!1,exports:{}};return e[t].call(n.exports,n,n.exports,u),n.l=!0,n.exports}u.e=function(e){var t=[],n={galerie:1};o[e]?t.push(o[e]):0!==o[e]&&n[e]&&t.push(o[e]=new Promise((function(t,n){for(var r="static/css/"+({about:"about",galerie:"galerie"}[e]||e)+"."+{about:"31d6cfe0",galerie:"7cb09891"}[e]+".css",a=u.p+r,i=document.getElementsByTagName("link"),c=0;c<i.length;c++){var l=i[c],s=l.getAttribute("data-href")||l.getAttribute("href");if("stylesheet"===l.rel&&(s===r||s===a))return t()}var d=document.getElementsByTagName("style");for(c=0;c<d.length;c++){l=d[c],s=l.getAttribute("data-href");if(s===r||s===a)return t()}var f=document.createElement("link");f.rel="stylesheet",f.type="text/css",f.onload=t,f.onerror=function(t){var r=t&&t.target&&t.target.src||a,i=new Error("Loading CSS chunk "+e+" failed.\n("+r+")");i.code="CSS_CHUNK_LOAD_FAILED",i.request=r,delete o[e],f.parentNode.removeChild(f),n(i)},f.href=a;var b=document.getElementsByTagName("head")[0];b.appendChild(f)})).then((function(){o[e]=0})));var r=a[e];if(0!==r)if(r)t.push(r[2]);else{var i=new Promise((function(t,n){r=a[e]=[t,n]}));t.push(r[2]=i);var l,s=document.createElement("script");s.charset="utf-8",s.timeout=120,u.nc&&s.setAttribute("nonce",u.nc),s.src=c(e);var d=new Error;l=function(t){s.onerror=s.onload=null,clearTimeout(f);var n=a[e];if(0!==n){if(n){var r=t&&("load"===t.type?"missing":t.type),o=t&&t.target&&t.target.src;d.message="Loading chunk "+e+" failed.\n("+r+": "+o+")",d.name="ChunkLoadError",d.type=r,d.request=o,n[1](d)}a[e]=void 0}};var f=setTimeout((function(){l({type:"timeout",target:s})}),12e4);s.onerror=s.onload=l,document.head.appendChild(s)}return Promise.all(t)},u.m=e,u.c=r,u.d=function(e,t,n){u.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:n})},u.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},u.t=function(e,t){if(1&t&&(e=u(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var n=Object.create(null);if(u.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var r in e)u.d(n,r,function(t){return e[t]}.bind(null,r));return n},u.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return u.d(t,"a",t),t},u.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},u.p="/",u.oe=function(e){throw console.error(e),e};var l=window["webpackJsonp"]=window["webpackJsonp"]||[],s=l.push.bind(l);l.push=t,l=l.slice();for(var d=0;d<l.length;d++)t(l[d]);var f=s;i.push([0,"chunk-vendors"]),n()})({0:function(e,t,n){e.exports=n("56d7")},"04d9":function(e,t,n){},"070d":function(e,t,n){"use strict";n("825e")},4196:function(e,t,n){"use strict";n("04d9")},"56d7":function(e,t,n){"use strict";n.r(t);n("e260"),n("e6cf"),n("cca6"),n("a79d");var r=n("7a23"),o={id:"nav"},a=Object(r["f"])("Home"),i=Object(r["f"])(" | "),c=Object(r["f"])("About"),u=Object(r["f"])(" | "),l=Object(r["f"])("Galerie");function s(e,t){var n=Object(r["w"])("router-link"),s=Object(r["w"])("router-view");return Object(r["p"])(),Object(r["d"])(r["a"],null,[Object(r["g"])("div",o,[Object(r["g"])(n,{to:"/"},{default:Object(r["B"])((function(){return[a]})),_:1}),i,Object(r["g"])(n,{to:"/about"},{default:Object(r["B"])((function(){return[c]})),_:1}),u,Object(r["g"])(n,{to:"/galerie"},{default:Object(r["B"])((function(){return[l]})),_:1})]),Object(r["g"])(s)],64)}n("4196");const d={};d.render=s;var f=d,b=(n("d3b7"),n("3ca3"),n("ddb0"),n("6c02")),p=n("cf05"),g=n.n(p),m={class:"home"},v=Object(r["g"])("img",{alt:"Vue logo",src:g.a},null,-1);function j(e,t,n,o,a,i){var c=Object(r["w"])("HelloWorld");return Object(r["p"])(),Object(r["d"])("div",m,[v,Object(r["g"])(c,{msg:"Welcome to Your Vue.js App"})])}var h=Object(r["C"])("data-v-28051039");Object(r["s"])("data-v-28051039");var O={class:"hello"},y={class:"select-image"},w=Object(r["g"])("p",null,"Type d'accès aux images : ",-1),I=Object(r["f"])(" Par identifiant"),k=Object(r["g"])("br",null,null,-1),C=Object(r["f"])(" Par nom de fichier"),_=Object(r["g"])("br",null,null,-1),S=Object(r["g"])("option",{disabled:"",selected:"",value:"0"},"Selectionnez votre image",-1),F=Object(r["g"])("img",{class:"imageEl",src:"",alt:"image"},null,-1),E={class:"formFilter"},T=Object(r["g"])("h1",null,"Filtre d'image",-1),q=Object(r["e"])('<select name="filter" required data-v-28051039><option value="ColorToGray" data-v-28051039>Filtre noir et blanc</option><option value="HueFilter" data-v-28051039>Filtre nuance</option><option value="contrast" data-v-28051039>Filtre contraste </option><option value="Ehistogramme" data-v-28051039>Filtre Egalisation d&#39;histogramme </option></select><button type="submit" name="filter-submited" data-v-28051039>Appliquer</button>',2),A=Object(r["g"])("option",{disabled:"",selected:"",value:"0"},"Filtre d'image",-1),P=Object(r["g"])("option",{value:"ColorToGray"},"Filtre noir et blanc",-1),x=Object(r["g"])("option",{value:"HueFilter"},"Filtre de nuance",-1),H={class:"add-image"};Object(r["q"])();var B=h((function(e,t,n,o,a,i){return Object(r["p"])(),Object(r["d"])("div",O,[Object(r["g"])("div",y,[w,Object(r["g"])("input",{type:"radio",onClick:t[1]||(t[1]=function(t){return e.callRestService()}),id:"identifiant",name:"remarque",value:"news"}),I,k,Object(r["g"])("input",{type:"radio",onClick:t[2]||(t[2]=function(t){return e.callRestService()}),id:"fichier",name:"remarque",value:"commentaire"}),C,_,Object(r["g"])("select",{onClick:t[3]||(t[3]=function(t){return e.getImage()})},[S,(Object(r["p"])(!0),Object(r["d"])(r["a"],null,Object(r["v"])(e.response,(function(t){return Object(r["p"])(),Object(r["d"])("option",{key:t,value:t.id},Object(r["y"])(e.Form_Images(t)),9,["value"])})),128))]),F,Object(r["g"])("button",{class:"Delete_picture",onClick:t[4]||(t[4]=function(t){return e.Delete_Image()})},"Cliquez ici pour supprimer l'image sélectionnée ")]),Object(r["g"])("div",E,[T,Object(r["g"])("form",{onSubmit:t[6]||(t[6]=function(t){return e.filterIMG()}),action:"",method:"get"},[Object(r["g"])("select",{name:"image",onClick:t[5]||(t[5]=function(t){return e.getImage()}),required:""},[(Object(r["p"])(!0),Object(r["d"])(r["a"],null,Object(r["v"])(e.response,(function(t){return Object(r["p"])(),Object(r["d"])("option",{key:t,value:t.id},Object(r["y"])(e.Form_Images(t)),9,["value"])})),128))]),q],32)]),Object(r["g"])("select",{onClick:t[7]||(t[7]=function(t){return e.applyFilter()})},[A,P,x]),Object(r["g"])("div",H,[Object(r["g"])("input",{type:"file",id:"file",ref:"file",onChange:t[8]||(t[8]=function(t){return e.addImage()})},null,544),Object(r["g"])("button",{onClick:t[9]||(t[9]=function(t){return e.submitImage()})},"ajouter")])])})),D=(n("b0c0"),n("bc3a")),M=n.n(D),G={name:"HelloWorld",props:{msg:String},el:".hello",data:function(){return{response:[],errors:[],file:""}},created:function(){},beforeMount:function(){},mounted:function(){this.callRestService(),this.getImage()},methods:{filterIMG:function(){M.a.get("/images/1",{responseType:"blob"}).then((function(){alert("ok")}))},callRestService:function(){var e=this;M.a.get("images").then((function(t){e.response=t.data})).catch((function(t){e.errors.push(t)}))},getImage:function(){var e=this.$el.querySelector("img"),t=this.$el.querySelector("select"),n=t.options[t.selectedIndex].value;M.a.get("images/"+n,{responseType:"blob"}).then((function(t){var n=new window.FileReader;n.readAsDataURL(t.data),n.onload=function(){var t=n.result;e.setAttribute("src",t)}}))},addImage:function(){this.file=this.$refs.file.files[0]},submitImage:function(){var e=new FormData;e.append("file",this.file),M.a.post("/images",e,{headers:{"Content-Type":"multipart/form-data"}}).then((function(){alert("Image ajoutée"),document.location.href="/"})).catch((function(){alert("Votre image n'a pas pu être ajoutée")}))},Delete_Image:function(){var e=this.$el.querySelector("select"),t=e.options[e.selectedIndex].value;M.a.delete("images/"+t,{responseType:"blob"}),document.location.href="/"},Form_Images:function(e){return document.getElementById("fichier").checked?e.name:document.getElementById("identifiant").checked?e.id:e.name}}};n("070d");G.render=B,G.__scopeId="data-v-28051039";var L=G,R={name:"Home",components:{HelloWorld:L}};R.render=j;var N=R,W=[{path:"/",name:"Home",component:N},{path:"/about",name:"About",component:function(){return n.e("about").then(n.bind(null,"f820"))}},{path:"/galerie",name:"Galerie",component:function(){return n.e("galerie").then(n.bind(null,"89dc"))}}],$=Object(b["a"])({history:Object(b["b"])("/"),routes:W}),V=$;Object(r["c"])(f).use(V).mount("#app")},"825e":function(e,t,n){},cf05:function(e,t,n){e.exports=n.p+"static/img/logo.82b9c7a5.png"}});
//# sourceMappingURL=app.867015a3.js.map