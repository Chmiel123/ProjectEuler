package chmiel.utils

class BitField {
  byte[] bits

  BitField(int n) {
    bits = new byte[(int)Math.ceil(n/8.0)]
  }
  def getAt(int i) {
    ((bits[i/8] >> 7-(i%8)) & 1) as boolean
  }
  void putAt(int i, def value) {
    def bit = 1 << 7-(i%8)
    if (value)
      bits[i/8] |= bit
    else
      bits[i/8] &= !bit
  }
  int getLength() {
    return bits.length * 8
  }
  String toString() {
    "[${bits.collect{String.format("%8s", Integer.toBinaryString(it & 0xFF)).replace(' ', '0')}.join('|')}]"
  }
}