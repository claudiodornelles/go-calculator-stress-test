pipeline {

   agent any

   stages {
      stage('Run Gatling stress test') {
         steps {
            sh './gradlew gatlingRun JAVA_OPTS="-Dusers=50"'
         }
      }
   }
}
