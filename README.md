1 - Ajouter le framework.jar dans le lib de votre projet
2 - Toutes les classes controllers doivent etre annotee : `@Controller`
4 - Principalement, toutes les controllers doivent etre dans le meme package `nom_package`
3 - Dans votre fichier `web.xml` ajouter les lignes suivantes :
  `<context-param>
      <param-name>Controller</param-name>
      <param-value>nom_package</param-value>
   </context-param>`
