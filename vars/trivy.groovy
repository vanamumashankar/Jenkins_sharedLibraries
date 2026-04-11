def call(String filename){
  sh """
  echo "Trivy Scaning started from here"
  echo "====================================================="
  trivy fs --format table -o ${filename}-report.html .
  echo "====================================================="
  echo "trvivy scnanned docker image and report has been generated as ${filename}-report.html" 
  """
}
