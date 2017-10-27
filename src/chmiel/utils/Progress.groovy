package chmiel.utils

class Progress {
  def static strLength = 0
  def static iter = 0
  
  static void update(String str) {
    update(str,1)
  }
  static void update(String str, int modulo) {
    if (iter % modulo == 0) {
      str
      strLength.times {
        print("\b")
      }
      strLength = str.length()
      print(str)
    }
    iter++
  }
  static void reset() {
    println()
    strLength = 0
    iter = 0
  }
}