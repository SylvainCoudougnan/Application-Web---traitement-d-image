(function(e){function t(t){for(var a,i,o=t[0],c=t[1],u=t[2],d=0,s=[];d<o.length;d++)i=o[d],Object.prototype.hasOwnProperty.call(r,i)&&r[i]&&s.push(r[i][0]),r[i]=0;for(a in c)Object.prototype.hasOwnProperty.call(c,a)&&(e[a]=c[a]);m&&m(t);while(s.length)s.shift()();return l.push.apply(l,u||[]),n()}function n(){for(var e,t=0;t<l.length;t++){for(var n=l[t],a=!0,i=1;i<n.length;i++){var o=n[i];0!==r[o]&&(a=!1)}a&&(l.splice(t--,1),e=c(c.s=n[0]))}return e}var a={},i={app:0},r={app:0},l=[];function o(e){return c.p+"static/js/"+({about:"about",galerie:"galerie"}[e]||e)+"."+{about:"867db854",galerie:"6f011d2c"}[e]+".js"}function c(t){if(a[t])return a[t].exports;var n=a[t]={i:t,l:!1,exports:{}};return e[t].call(n.exports,n,n.exports,c),n.l=!0,n.exports}c.e=function(e){var t=[],n={galerie:1};i[e]?t.push(i[e]):0!==i[e]&&n[e]&&t.push(i[e]=new Promise((function(t,n){for(var a="static/css/"+({about:"about",galerie:"galerie"}[e]||e)+"."+{about:"31d6cfe0",galerie:"ba3ce6c5"}[e]+".css",r=c.p+a,l=document.getElementsByTagName("link"),o=0;o<l.length;o++){var u=l[o],d=u.getAttribute("data-href")||u.getAttribute("href");if("stylesheet"===u.rel&&(d===a||d===r))return t()}var s=document.getElementsByTagName("style");for(o=0;o<s.length;o++){u=s[o],d=u.getAttribute("data-href");if(d===a||d===r)return t()}var m=document.createElement("link");m.rel="stylesheet",m.type="text/css",m.onload=t,m.onerror=function(t){var a=t&&t.target&&t.target.src||r,l=new Error("Loading CSS chunk "+e+" failed.\n("+a+")");l.code="CSS_CHUNK_LOAD_FAILED",l.request=a,delete i[e],m.parentNode.removeChild(m),n(l)},m.href=r;var g=document.getElementsByTagName("head")[0];g.appendChild(m)})).then((function(){i[e]=0})));var a=r[e];if(0!==a)if(a)t.push(a[2]);else{var l=new Promise((function(t,n){a=r[e]=[t,n]}));t.push(a[2]=l);var u,d=document.createElement("script");d.charset="utf-8",d.timeout=120,c.nc&&d.setAttribute("nonce",c.nc),d.src=o(e);var s=new Error;u=function(t){d.onerror=d.onload=null,clearTimeout(m);var n=r[e];if(0!==n){if(n){var a=t&&("load"===t.type?"missing":t.type),i=t&&t.target&&t.target.src;s.message="Loading chunk "+e+" failed.\n("+a+": "+i+")",s.name="ChunkLoadError",s.type=a,s.request=i,n[1](s)}r[e]=void 0}};var m=setTimeout((function(){u({type:"timeout",target:d})}),12e4);d.onerror=d.onload=u,document.head.appendChild(d)}return Promise.all(t)},c.m=e,c.c=a,c.d=function(e,t,n){c.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:n})},c.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},c.t=function(e,t){if(1&t&&(e=c(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var n=Object.create(null);if(c.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var a in e)c.d(n,a,function(t){return e[t]}.bind(null,a));return n},c.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return c.d(t,"a",t),t},c.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},c.p="/",c.oe=function(e){throw console.error(e),e};var u=window["webpackJsonp"]=window["webpackJsonp"]||[],d=u.push.bind(u);u.push=t,u=u.slice();for(var s=0;s<u.length;s++)t(u[s]);var m=d;l.push([0,"chunk-vendors"]),n()})({0:function(e,t,n){e.exports=n("56d7")},"04d9":function(e,t,n){},"3e74":function(e,t,n){"use strict";n("d344")},4196:function(e,t,n){"use strict";n("04d9")},"56d7":function(e,t,n){"use strict";n.r(t);n("e260"),n("e6cf"),n("cca6"),n("a79d");var a=n("7a23"),i={id:"nav"},r=Object(a["f"])("Home"),l=Object(a["f"])(" | "),o=Object(a["f"])("About"),c=Object(a["f"])(" | "),u=Object(a["f"])("Galerie");function d(e,t){var n=Object(a["w"])("router-link"),d=Object(a["w"])("router-view");return Object(a["p"])(),Object(a["d"])(a["a"],null,[Object(a["g"])("div",i,[Object(a["g"])(n,{to:"/"},{default:Object(a["B"])((function(){return[r]})),_:1}),l,Object(a["g"])(n,{to:"/about"},{default:Object(a["B"])((function(){return[o]})),_:1}),c,Object(a["g"])(n,{to:"/galerie"},{default:Object(a["B"])((function(){return[u]})),_:1})]),Object(a["g"])(d)],64)}n("4196");const s={};s.render=d;var m=s,g=(n("d3b7"),n("3ca3"),n("ddb0"),n("6c02")),f=n("cf05"),p=n.n(f),b={class:"home"},v=Object(a["g"])("img",{alt:"Vue logo",src:p.a},null,-1);function j(e,t,n,i,r,l){var o=Object(a["w"])("HelloWorld");return Object(a["p"])(),Object(a["d"])("div",b,[v,Object(a["g"])(o,{msg:"Welcome to Your Vue.js App"})])}var y=Object(a["C"])("data-v-5e3b2e75");Object(a["s"])("data-v-5e3b2e75");var O={class:"hello"},h=Object(a["g"])("p",{id:"bienvenue"}," Bienvenue dans cette application web dédiée au traitement d'image. Pour télécharger une image située sur le serveur (avant/après) traitement cliquer sur l'image. Bonne navigation ! ",-1),I={class:"select-image"},_=Object(a["g"])("p",null,"Type d'accès aux images : ",-1),E=Object(a["f"])(" Par identifiant"),B=Object(a["g"])("br",null,null,-1),w=Object(a["f"])(" Par nom de fichier"),k=Object(a["g"])("br",null,null,-1),x=Object(a["f"])(" Par taille"),T=Object(a["g"])("br",null,null,-1),S=Object(a["f"])(" Visualiser toutes les métadonnées"),C=Object(a["g"])("br",null,null,-1),H=Object(a["g"])("option",{disabled:"",selected:"",value:"0"},"Selectionnez votre image",-1),M=Object(a["g"])("figure",null,[Object(a["g"])("a",{href:"",id:"img_dl",download:"imagepastraite"},[Object(a["g"])("img",{class:"imageEl",src:""})]),Object(a["g"])("div",{class:"metadata"},[Object(a["g"])("figcaption",{id:"meta_images"})])],-1),A=Object(a["g"])("img",{class:"imageEl",src:""},null,-1),L={class:"formFilter"},P=Object(a["g"])("h1",null,"Filtre d'image",-1),q=Object(a["e"])('<option selected value="ColorToGray" data-v-5e3b2e75>Colorer en gris</option><option value="HueFilter" data-v-5e3b2e75> Teinter l&#39;image</option><option value="contrast" data-v-5e3b2e75>Contraste </option><option value="Ehistogramme" data-v-5e3b2e75> Egalisation d&#39;histogramme</option><option value="brighness" data-v-5e3b2e75> Modification de luminosité</option><option value="gauss" data-v-5e3b2e75> Flou</option><option value="sobel" data-v-5e3b2e75> Sobel</option>',7),F=Object(a["g"])("div",{id:"param1"},[Object(a["g"])("p",null," Valeur de teinte : "),Object(a["g"])("input",{type:"range",id:"range",min:"0",max:"359",step:"1.0",onchange:"document.getElementById('param').innerHTML=this.value"}),Object(a["g"])("strong",{id:"param"},"10")],-1),R=Object(a["g"])("div",{id:"param_min_max"},[Object(a["g"])("p",null," Valeur minimum : "),Object(a["g"])("input",{type:"range",id:"range_minimum",min:"0",max:"255",step:"1.0",onchange:"document.getElementById('range_min').innerHTML=this.value"}),Object(a["g"])("strong",{id:"range_min"},"10"),Object(a["g"])("p",null," Valeur maximum : "),Object(a["g"])("input",{type:"range",id:"range_maximum",min:"0",max:"255",step:"1.0",onchange:"document.getElementById('range_max').innerHTML=this.value"}),Object(a["g"])("strong",{id:"range_max"},"10")],-1),V=Object(a["g"])("div",{id:"param_lum"},[Object(a["g"])("p",null," Valeur : "),Object(a["g"])("input",{type:"range",id:"range_lum",min:"-255",max:"255",step:"1.0",onchange:"document.getElementById('luminosite').innerHTML=this.value"}),Object(a["g"])("strong",{id:"luminosite"},"10")],-1),D=Object(a["g"])("div",{id:"flou"},[Object(a["g"])("input",{type:"radio",id:"middle",value:"0",name:"flou"}),Object(a["f"])(" Moyen"),Object(a["g"])("br"),Object(a["g"])("input",{type:"radio",id:"gauss",value:"1",name:"flou"}),Object(a["f"])(" Gaussien"),Object(a["g"])("br")],-1),z=Object(a["g"])("p",{id:"message_traitement"},null,-1),G=Object(a["g"])("a",{href:"",id:"img_filter_dl",download:"imagetraité"},[Object(a["g"])("img",{class:"image_after_filtre",src:"",id:"img_filter"})],-1),N={class:"add-image"};Object(a["q"])();var $=y((function(e,t,n,i,r,l){return Object(a["p"])(),Object(a["d"])("div",O,[h,Object(a["g"])("div",I,[_,Object(a["g"])("input",{type:"radio",onClick:t[1]||(t[1]=function(t){return e.callRestService()}),id:"identifiant",name:"remarque",value:"news"}),E,B,Object(a["g"])("input",{type:"radio",onClick:t[2]||(t[2]=function(t){return e.callRestService()}),id:"fichier",name:"remarque",value:"commentaire"}),w,k,Object(a["g"])("input",{type:"radio",onClick:t[3]||(t[3]=function(t){return e.callRestService()}),id:"taille",name:"remarque",value:"size"}),x,T,Object(a["g"])("input",{type:"radio",onClick:t[4]||(t[4]=function(t){return e.callRestService()}),id:"metadata_all",name:"remarque",value:"metadata"}),S,C,Object(a["g"])("select",{onClick:t[5]||(t[5]=function(t){return e.getImage()})},[H,(Object(a["p"])(!0),Object(a["d"])(a["a"],null,Object(a["v"])(e.response,(function(t){return Object(a["p"])(),Object(a["d"])("option",{key:t,value:t.id},Object(a["y"])(e.Form_Images(t)),9,["value"])})),128))]),M,Object(a["g"])("button",{class:"delete_picture",onClick:t[6]||(t[6]=function(t){return e.Delete_Image()})},"Supprimer l'image sélectionnée ")]),A,Object(a["g"])("div",L,[P,Object(a["g"])("select",{onClick:t[7]||(t[7]=function(t){return e.affiche()}),id:"filterselect"},[q]),F,R,V,D,Object(a["g"])("button",{onClick:t[8]||(t[8]=function(t){return e.filterIMG()})},"Appliquer le filtre"),z,G]),Object(a["g"])("div",N,[Object(a["g"])("input",{type:"file",id:"file",ref:"file",onChange:t[9]||(t[9]=function(t){return e.addImage()})},null,544),Object(a["g"])("button",{onClick:t[10]||(t[10]=function(t){return e.submitImage()})},"ajouter")])])})),W=(n("b0c0"),n("bc3a")),U=n.n(W),J={name:"HelloWorld",props:{msg:String},el:".hello",data:function(){return{response:[],errors:[],file:""}},created:function(){},beforeMount:function(){},mounted:function(){this.callRestService(),this.getImage(),this.affiche()},methods:{filterIMG:function(){document.getElementById("message_traitement").innerHTML="<span id='test'>Traitement de l'image en cours ...</span>";var e=document.getElementById("img_filter"),t=document.getElementById("img_filter_dl"),n=this.$el.querySelector("select"),a=n.options[n.selectedIndex].value,i=document.getElementById("filterselect"),r=i.options[i.selectedIndex].value,l=document.getElementById("range").value;"contrast"==document.getElementById("filterselect").value&&(l=document.getElementById("range_minimum").value),"brighness"==document.getElementById("filterselect").value&&(l=document.getElementById("range_lum").value);var o=document.getElementById("range_maximum").value;"contrast"==document.getElementById("filterselect").value&&o<l&&alert("Veuillez saisir une valeur minimum inférieure à celle du maximum"),"gauss"==document.getElementById("filterselect").value&&(document.getElementById("gauss").checked?(l=1,console.log("gauss")):l=0),U.a.get("images/"+a+"?algorithm="+r+"&arg1="+l+"&arg2="+o,{responseType:"blob"}).then((function(n){var a=new window.FileReader;a.readAsDataURL(n.data),a.onload=function(){var n=a.result;e.setAttribute("src",n),t.setAttribute("href",n),document.getElementById("message_traitement").innerHTML="<span id='test'>...Terminé !</span>"}}))},affiche:function(){document.getElementById("param1").style.display="none",document.getElementById("param_min_max").style.display="none",document.getElementById("param_lum").style.display="none",document.getElementById("flou").style.display="none","HueFilter"==document.getElementById("filterselect").value?document.getElementById("param1").style.display="block":"contrast"==document.getElementById("filterselect").value?document.getElementById("param_min_max").style.display="block":"brighness"==document.getElementById("filterselect").value?document.getElementById("param_lum").style.display="block":"gauss"==document.getElementById("filterselect").value&&(document.getElementById("flou").style.display="block")},callRestService:function(){var e=this;U.a.get("images").then((function(t){e.response=t.data})).catch((function(t){e.errors.push(t)}))},getImage:function(){var e=this.$el.querySelector("img"),t=this.$el.querySelector("select"),n=t.options[t.selectedIndex].value,a=document.getElementById("img_dl");U.a.get("images/"+n,{responseType:"blob"}).then((function(t){var i=new window.FileReader;i.readAsDataURL(t.data),i.onload=function(){var t=i.result;e.setAttribute("src",t),a.setAttribute("href",t),document.getElementById("meta_images").innerHTML="Identifiant de l'image : "+n;var r=document.getElementById("size");r.innerHTML="un autre texte"}}))},test_id:function(e){return e.size},addImage:function(){this.file=this.$refs.file.files[0]},submitImage:function(){var e=new FormData;e.append("file",this.file),U.a.post("/images",e,{headers:{"Content-Type":"multipart/form-data"}}).then((function(){alert("Image ajoutée"),document.location.href="/"})).catch((function(){alert("Votre image n'a pas pu être ajoutée")}))},Delete_Image:function(){var e=this.$el.querySelector("select"),t=e.options[e.selectedIndex].value;U.a.delete("images/"+t,{responseType:"blob"}),document.location.href="/"},Form_Images:function(e){return document.getElementById("fichier").checked?e.name:document.getElementById("identifiant").checked?e.id:document.getElementById("taille").checked?e.size:document.getElementById("metadata_all").checked?e:e.name}}};n("3e74");J.render=$,J.__scopeId="data-v-5e3b2e75";var K=J,Y={name:"Home",components:{HelloWorld:K}};Y.render=j;var Q=Y,X=[{path:"/",name:"Home",component:Q},{path:"/about",name:"About",component:function(){return n.e("about").then(n.bind(null,"f820"))}},{path:"/galerie",name:"Galerie",component:function(){return n.e("galerie").then(n.bind(null,"89dc"))}}],Z=Object(g["a"])({history:Object(g["b"])("/"),routes:X}),ee=Z;Object(a["c"])(m).use(ee).mount("#app")},cf05:function(e,t,n){e.exports=n.p+"static/img/logo.82b9c7a5.png"},d344:function(e,t,n){}});
//# sourceMappingURL=app.48a8b851.js.map