// DO NOT EDIT
// Generated by JFlex 1.9.1 http://jflex.de/
// source: src/main/java/gt/edu/usac/ingenieria/analyzer/statpy/StatPy.flex

// package and imports
package gt.edu.usac.ingenieria.analyzer.statpy;
import java_cup.runtime.*;
import java_cup.sym;
import java.util.ArrayList;
import gt.edu.usac.ingenieria.analyzer.errors.ErrorStpL;


@SuppressWarnings("fallthrough")
public class STPLexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = {
     0,  0,  0,  0,  0,  0,  0,  0,  0,  1,  2,  3,  3,  4,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     1,  5,  6,  0,  7,  0,  8,  9, 10, 11, 12, 13, 14, 15, 16, 17, 
    18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 19, 20, 21, 22,  0, 
     0, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 
    32, 32, 38, 39, 40, 41, 42, 43, 32, 32, 32, 44, 45, 46,  0, 47, 
     0, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 
    32, 32, 38, 39, 40, 41, 42, 43, 32, 32, 32, 48, 49, 50,  0,  0, 
     0,  0,  0,  0,  0,  3,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0, 32,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0, 32,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0
  };

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\1\1\5\2\1"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\15\22\1\23\1\24\1\1"+
    "\1\25\1\1\1\26\1\27\1\0\1\30\1\0\1\31"+
    "\3\0\1\2\1\0\1\32\1\33\1\34\6\22\1\35"+
    "\3\22\1\36\10\22\1\0\1\37\1\40\1\0\1\41"+
    "\11\22\1\42\1\43\7\22\1\2\1\44\1\22\1\45"+
    "\1\46\3\22\1\47\1\22\1\50\3\22\1\51\1\52"+
    "\1\22\1\53\3\22\1\54\3\22\1\55\2\22\1\56"+
    "\1\57\1\60\1\61\1\22\1\62\1\63";

  private static int [] zzUnpackAction() {
    int [] result = new int[130];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\63\0\146\0\63\0\231\0\314\0\63\0\377"+
    "\0\u0132\0\63\0\63\0\63\0\63\0\63\0\63\0\u0165"+
    "\0\u0198\0\63\0\u01cb\0\u01fe\0\u0231\0\u0264\0\u0297\0\u02ca"+
    "\0\u02fd\0\u0330\0\u0363\0\u0396\0\u03c9\0\u03fc\0\u042f\0\u0462"+
    "\0\u0495\0\u04c8\0\63\0\63\0\u04fb\0\63\0\u052e\0\63"+
    "\0\63\0\314\0\63\0\u0561\0\63\0\u0594\0\u05c7\0\u05fa"+
    "\0\u062d\0\u0660\0\63\0\63\0\63\0\u0693\0\u06c6\0\u06f9"+
    "\0\u072c\0\u075f\0\u0792\0\u07c5\0\u07f8\0\u082b\0\u085e\0\u0264"+
    "\0\u0891\0\u08c4\0\u08f7\0\u092a\0\u095d\0\u0990\0\u09c3\0\u09f6"+
    "\0\u04fb\0\63\0\63\0\u0a29\0\u0660\0\u0a5c\0\u0a8f\0\u0ac2"+
    "\0\u0af5\0\u0b28\0\u0b5b\0\u0b8e\0\u0bc1\0\u0bf4\0\u0264\0\u0264"+
    "\0\u0c27\0\u0c5a\0\u0c8d\0\u0cc0\0\u0cf3\0\u0d26\0\u0d59\0\63"+
    "\0\u0264\0\u0d8c\0\u0264\0\u0264\0\u0dbf\0\u0df2\0\u0e25\0\u0264"+
    "\0\u0e58\0\u0264\0\u0e8b\0\u0ebe\0\u0ef1\0\u0264\0\u0264\0\u0f24"+
    "\0\u0264\0\u0f57\0\u0f8a\0\u0fbd\0\u0264\0\u0ff0\0\u1023\0\u1056"+
    "\0\u0264\0\u1089\0\u10bc\0\u0264\0\u0264\0\u0264\0\u0264\0\u10ef"+
    "\0\u0264\0\u0264";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[130];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length() - 1;
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpacktrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\0\1\3\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\2\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\1\27\1\30\1\31\1\32\1\33\2\26\1\34\3\26"+
    "\1\35\2\26\1\36\1\37\1\40\1\26\1\41\1\42"+
    "\1\43\1\2\1\44\1\45\1\46\1\47\1\50\64\0"+
    "\1\3\2\0\1\3\103\0\1\51\35\0\2\52\1\0"+
    "\3\52\1\53\46\52\1\54\5\52\10\0\1\55\52\0"+
    "\2\56\1\0\3\56\1\0\46\56\1\57\5\56\14\0"+
    "\1\60\4\0\1\61\61\0\1\62\1\0\1\21\65\0"+
    "\1\63\62\0\1\64\62\0\1\65\57\0\1\26\4\0"+
    "\25\26\3\0\1\26\25\0\1\26\4\0\16\26\1\66"+
    "\1\67\5\26\3\0\1\26\25\0\1\26\4\0\1\70"+
    "\6\26\1\71\6\26\1\72\6\26\3\0\1\26\25\0"+
    "\1\26\4\0\4\26\1\73\11\26\1\74\6\26\3\0"+
    "\1\26\25\0\1\26\4\0\13\26\1\75\11\26\3\0"+
    "\1\26\25\0\1\26\4\0\1\76\15\26\1\77\6\26"+
    "\3\0\1\26\25\0\1\26\4\0\5\26\1\100\7\26"+
    "\1\101\7\26\3\0\1\26\25\0\1\26\4\0\1\102"+
    "\24\26\3\0\1\26\25\0\1\26\4\0\4\26\1\103"+
    "\20\26\3\0\1\26\25\0\1\26\4\0\21\26\1\104"+
    "\2\26\1\105\3\0\1\26\25\0\1\26\4\0\17\26"+
    "\1\106\5\26\3\0\1\26\25\0\1\26\4\0\16\26"+
    "\1\107\6\26\3\0\1\26\25\0\1\26\4\0\7\26"+
    "\1\110\15\26\3\0\1\26\32\0\25\26\3\0\1\111"+
    "\64\0\1\112\1\0\2\52\3\0\56\52\11\0\1\113"+
    "\51\0\2\56\3\0\56\56\14\60\1\114\46\60\2\61"+
    "\1\0\1\61\1\0\56\61\22\0\1\115\62\0\1\26"+
    "\4\0\16\26\1\116\6\26\3\0\1\26\25\0\1\26"+
    "\4\0\4\26\1\117\20\26\3\0\1\26\25\0\1\26"+
    "\4\0\20\26\1\120\4\26\3\0\1\26\25\0\1\26"+
    "\4\0\1\121\24\26\3\0\1\26\25\0\1\26\4\0"+
    "\15\26\1\122\7\26\3\0\1\26\25\0\1\26\4\0"+
    "\5\26\1\123\17\26\3\0\1\26\25\0\1\26\4\0"+
    "\22\26\1\124\2\26\3\0\1\26\25\0\1\26\4\0"+
    "\20\26\1\125\4\26\3\0\1\26\25\0\1\26\4\0"+
    "\13\26\1\126\11\26\3\0\1\26\25\0\1\26\4\0"+
    "\17\26\1\127\5\26\3\0\1\26\25\0\1\26\4\0"+
    "\21\26\1\130\3\26\3\0\1\26\25\0\1\26\4\0"+
    "\10\26\1\131\14\26\3\0\1\26\25\0\1\26\4\0"+
    "\21\26\1\132\3\26\3\0\1\26\25\0\1\26\4\0"+
    "\17\26\1\133\5\26\3\0\1\26\25\0\1\26\4\0"+
    "\10\26\1\134\14\26\3\0\1\26\25\0\1\26\4\0"+
    "\22\26\1\135\2\26\3\0\1\26\25\0\1\26\4\0"+
    "\10\26\1\136\14\26\3\0\1\26\25\0\1\26\4\0"+
    "\10\26\1\137\14\26\3\0\1\26\3\0\14\60\1\114"+
    "\4\60\1\140\41\60\22\0\1\26\4\0\13\26\1\141"+
    "\11\26\3\0\1\26\25\0\1\26\4\0\1\142\24\26"+
    "\3\0\1\26\25\0\1\26\4\0\4\26\1\143\20\26"+
    "\3\0\1\26\25\0\1\26\4\0\17\26\1\144\5\26"+
    "\3\0\1\26\25\0\1\26\4\0\21\26\1\145\3\26"+
    "\3\0\1\26\25\0\1\26\4\0\1\146\24\26\3\0"+
    "\1\26\25\0\1\26\4\0\1\26\1\147\23\26\3\0"+
    "\1\26\25\0\1\26\4\0\4\26\1\150\20\26\3\0"+
    "\1\26\25\0\1\26\4\0\20\26\1\151\4\26\3\0"+
    "\1\26\25\0\1\26\4\0\15\26\1\152\7\26\3\0"+
    "\1\26\25\0\1\26\4\0\22\26\1\153\2\26\3\0"+
    "\1\26\25\0\1\26\4\0\10\26\1\154\14\26\3\0"+
    "\1\26\25\0\1\26\4\0\21\26\1\155\3\26\3\0"+
    "\1\26\25\0\1\26\4\0\4\26\1\156\20\26\3\0"+
    "\1\26\25\0\1\26\4\0\3\26\1\157\21\26\3\0"+
    "\1\26\25\0\1\26\4\0\13\26\1\160\11\26\3\0"+
    "\1\26\25\0\1\26\4\0\12\26\1\161\12\26\3\0"+
    "\1\26\25\0\1\26\4\0\10\26\1\162\14\26\3\0"+
    "\1\26\25\0\1\26\4\0\22\26\1\163\2\26\3\0"+
    "\1\26\25\0\1\26\4\0\13\26\1\164\11\26\3\0"+
    "\1\26\25\0\1\26\4\0\4\26\1\165\20\26\3\0"+
    "\1\26\25\0\1\26\4\0\17\26\1\166\5\26\3\0"+
    "\1\26\25\0\1\26\4\0\15\26\1\167\7\26\3\0"+
    "\1\26\25\0\1\26\4\0\2\26\1\170\22\26\3\0"+
    "\1\26\25\0\1\26\4\0\4\26\1\171\20\26\3\0"+
    "\1\26\25\0\1\26\4\0\15\26\1\172\7\26\3\0"+
    "\1\26\25\0\1\26\4\0\13\26\1\173\11\26\3\0"+
    "\1\26\25\0\1\26\4\0\4\26\1\174\20\26\3\0"+
    "\1\26\25\0\1\26\4\0\15\26\1\175\7\26\3\0"+
    "\1\26\25\0\1\26\4\0\6\26\1\176\16\26\3\0"+
    "\1\26\25\0\1\26\4\0\7\26\1\177\15\26\3\0"+
    "\1\26\25\0\1\26\4\0\22\26\1\200\2\26\3\0"+
    "\1\26\25\0\1\26\4\0\21\26\1\201\3\26\3\0"+
    "\1\26\25\0\1\26\4\0\4\26\1\202\20\26\3\0"+
    "\1\26\3\0";

  private static int [] zzUnpacktrans() {
    int [] result = new int[4386];
    int offset = 0;
    offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpacktrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\1\1\1\11\2\1\1\11\2\1\6\11"+
    "\2\1\1\11\20\1\2\11\1\1\1\11\1\1\2\11"+
    "\1\0\1\11\1\0\1\11\3\0\1\1\1\0\3\11"+
    "\23\1\1\0\2\11\1\0\23\1\1\11\42\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[130];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen())];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */
    private ArrayList<ErrorStpL> errors = new ArrayList<>();
    private void addError(String value){
        errors.add(new ErrorStpL(yyline, yycolumn, value));
    }

    public ArrayList<ErrorStpL> getErrors(){
        return errors;
    }

    StringBuffer string = new StringBuffer();

    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public STPLexer(java.io.Reader in) {
      yyline = 1;
    this.zzReader = in;
  }


  /** Returns the maximum size of the scanner buffer, which limits the size of tokens. */
  private int zzMaxBufferLen() {
    return Integer.MAX_VALUE;
  }

  /**  Whether the scanner buffer can grow to accommodate a larger token. */
  private boolean zzCanGrow() {
    return true;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    return ZZ_CMAP[input];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate && zzCanGrow()) {
      /* if not, and it can grow: blow it up */
      char newBuffer[] = new char[Math.min(zzBuffer.length * 2, zzMaxBufferLen())];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      if (requested == 0) {
        throw new java.io.EOFException("Scan buffer limit reached ["+zzBuffer.length+"]");
      }
      else {
        throw new java.io.IOException(
            "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
      }
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    int initBufferSize = Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen());
    if (zzBuffer.length > initBufferSize) {
      zzBuffer = new char[initBufferSize];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @Override  public java_cup.runtime.Symbol next_token() throws java.io.IOException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { return new java_cup.runtime.Symbol(sym.EOF); }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { addError(yytext());
            }
          // fall through
          case 52: break;
          case 2:
            { 
            }
          // fall through
          case 53: break;
          case 3:
            { yycolumn = 1;
            }
          // fall through
          case 54: break;
          case 4:
            { return symbol(SYM.TK_NOT,          yytext());
            }
          // fall through
          case 55: break;
          case 5:
            { return symbol(SYM.TK_DOLL,         yytext());
            }
          // fall through
          case 56: break;
          case 6:
            { return symbol(SYM.TK_LPAR,         yytext());
            }
          // fall through
          case 57: break;
          case 7:
            { return symbol(SYM.TK_RPAR,         yytext());
            }
          // fall through
          case 58: break;
          case 8:
            { return symbol(SYM.TK_MULT,         yytext());
            }
          // fall through
          case 59: break;
          case 9:
            { return symbol(SYM.TK_PLUS,         yytext());
            }
          // fall through
          case 60: break;
          case 10:
            { return symbol(SYM.TK_COMA,         yytext());
            }
          // fall through
          case 61: break;
          case 11:
            { return symbol(SYM.TK_MINUS,        yytext());
            }
          // fall through
          case 62: break;
          case 12:
            { return symbol(SYM.TK_DIV,          yytext());
            }
          // fall through
          case 63: break;
          case 13:
            { return symbol(SYM.TK_INT,          yytext());
            }
          // fall through
          case 64: break;
          case 14:
            { return symbol(SYM.TK_SCOLON,       yytext());
            }
          // fall through
          case 65: break;
          case 15:
            { return symbol(SYM.TK_LESS,         yytext());
            }
          // fall through
          case 66: break;
          case 16:
            { return symbol(SYM.TK_EQ,           yytext());
            }
          // fall through
          case 67: break;
          case 17:
            { return symbol(SYM.TK_GREATER,      yytext());
            }
          // fall through
          case 68: break;
          case 18:
            { return symbol(SYM.TK_ID,           yytext());
            }
          // fall through
          case 69: break;
          case 19:
            { return symbol(SYM.TK_LBRK,         yytext());
            }
          // fall through
          case 70: break;
          case 20:
            { return symbol(SYM.TK_RBRK,         yytext());
            }
          // fall through
          case 71: break;
          case 21:
            { return symbol(SYM.TK_LBRC,         yytext());
            }
          // fall through
          case 72: break;
          case 22:
            { return symbol(SYM.TK_RBRC,         yytext());
            }
          // fall through
          case 73: break;
          case 23:
            { return symbol(SYM.TK_NOTEQ,        yytext());
            }
          // fall through
          case 74: break;
          case 24:
            { return symbol(SYM.TK_STRING,       yytext());
            }
          // fall through
          case 75: break;
          case 25:
            { return symbol(SYM.TK_AND,          yytext());
            }
          // fall through
          case 76: break;
          case 26:
            { return symbol(SYM.TK_LEQ,          yytext());
            }
          // fall through
          case 77: break;
          case 27:
            { return symbol(SYM.TK_EQEQ,         yytext());
            }
          // fall through
          case 78: break;
          case 28:
            { return symbol(SYM.TK_GEQ,          yytext());
            }
          // fall through
          case 79: break;
          case 29:
            { return symbol(SYM.KW_DO,           yytext());
            }
          // fall through
          case 80: break;
          case 30:
            { return symbol(SYM.KW_IF,           yytext());
            }
          // fall through
          case 81: break;
          case 31:
            { return symbol(SYM.TK_OR,           yytext());
            }
          // fall through
          case 82: break;
          case 32:
            { return symbol(SYM.TK_CHAR,         yytext());
            }
          // fall through
          case 83: break;
          case 33:
            { return symbol(SYM.TK_DOUBLE,       yytext());
            }
          // fall through
          case 84: break;
          case 34:
            { return symbol(SYM.KW_FOR,          yytext());
            }
          // fall through
          case 85: break;
          case 35:
            { return symbol(SYM.KW_INT,          yytext());
            }
          // fall through
          case 86: break;
          case 36:
            { return symbol(SYM.KW_BOOL,         yytext());
            }
          // fall through
          case 87: break;
          case 37:
            { return symbol(SYM.KW_CASE,         yytext());
            }
          // fall through
          case 88: break;
          case 38:
            { return symbol(SYM.KW_CHAR,         yytext());
            }
          // fall through
          case 89: break;
          case 39:
            { return symbol(SYM.KW_ELSE,         yytext());
            }
          // fall through
          case 90: break;
          case 40:
            { return symbol(SYM.KW_MAIN,         yytext());
            }
          // fall through
          case 91: break;
          case 41:
            { return symbol(SYM.KW_TRUE,         yytext());
            }
          // fall through
          case 92: break;
          case 42:
            { return symbol(SYM.KW_VOID,         yytext());
            }
          // fall through
          case 93: break;
          case 43:
            { return symbol(SYM.KW_BREAK,        yytext());
            }
          // fall through
          case 94: break;
          case 44:
            { return symbol(SYM.KW_FALSE,        yytext());
            }
          // fall through
          case 95: break;
          case 45:
            { return symbol(SYM.KW_WHILE,        yytext());
            }
          // fall through
          case 96: break;
          case 46:
            { return symbol(SYM.KW_DOUBLE,       yytext());
            }
          // fall through
          case 97: break;
          case 47:
            { return symbol(SYM.KW_RETURN,       yytext());
            }
          // fall through
          case 98: break;
          case 48:
            { return symbol(SYM.KW_STRING,       yytext());
            }
          // fall through
          case 99: break;
          case 49:
            { return symbol(SYM.KW_SWITCH,       yytext());
            }
          // fall through
          case 100: break;
          case 50:
            { return symbol(SYM.KW_DEFAULT,      yytext());
            }
          // fall through
          case 101: break;
          case 51:
            { return symbol(SYM.KW_CONTINUE,     yytext());
            }
          // fall through
          case 102: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
