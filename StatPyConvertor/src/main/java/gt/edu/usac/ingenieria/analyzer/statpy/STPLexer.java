// DO NOT EDIT
// Generated by JFlex 1.9.1 http://jflex.de/
// source: src/main/java/gt/edu/usac/ingenieria/analyzer/statpy/StatPy.flex

// package and imports
package gt.edu.usac.ingenieria.analyzer.statpy;
import java_cup.runtime.*;
import java_cup.sym;
import java.util.ArrayList;
import gt.edu.usac.ingenieria.analyzer.errors.LexError;


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
    18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 19, 20, 21, 22, 23,  0, 
     0, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
    39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 40, 49, 50, 51,  0, 52, 
     0, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
    39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 40, 53, 54, 55,  0,  0, 
     0,  0,  0,  0,  0,  3,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0, 40,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0, 40,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0
  };

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\1\1\5\2\1"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\16\23\1\24\1\25"+
    "\1\1\1\26\1\1\1\27\1\30\1\0\1\31\1\0"+
    "\1\32\2\0\1\33\1\34\1\0\1\2\1\0\1\35"+
    "\1\36\1\37\6\23\1\40\5\23\1\41\12\23\1\0"+
    "\1\42\1\43\1\0\1\44\12\23\1\45\1\23\1\46"+
    "\11\23\1\2\1\47\1\23\1\50\1\51\4\23\1\52"+
    "\1\53\2\23\1\54\4\23\1\55\1\23\1\56\1\23"+
    "\1\57\4\23\1\60\6\23\1\61\3\23\1\62\1\23"+
    "\1\63\1\64\1\65\1\66\2\23\1\67\2\23\1\70"+
    "\1\71\1\72\1\73\10\23\1\74\5\23\1\75\1\23"+
    "\1\76";

  private static int [] zzUnpackAction() {
    int [] result = new int[177];
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
    "\0\0\0\70\0\160\0\70\0\250\0\340\0\70\0\u0118"+
    "\0\u0150\0\70\0\70\0\70\0\u0188\0\70\0\u01c0\0\u01f8"+
    "\0\u0230\0\70\0\70\0\u0268\0\u02a0\0\u02d8\0\u0310\0\u0348"+
    "\0\u0380\0\u03b8\0\u03f0\0\u0428\0\u0460\0\u0498\0\u04d0\0\u0508"+
    "\0\u0540\0\u0578\0\u05b0\0\u05e8\0\70\0\70\0\u0620\0\70"+
    "\0\u0658\0\70\0\70\0\340\0\70\0\u0690\0\70\0\u06c8"+
    "\0\u0700\0\70\0\70\0\u0738\0\u0770\0\u07a8\0\70\0\70"+
    "\0\70\0\u07e0\0\u0818\0\u0850\0\u0888\0\u08c0\0\u08f8\0\u0930"+
    "\0\u0968\0\u09a0\0\u09d8\0\u0a10\0\u0a48\0\u0310\0\u0a80\0\u0ab8"+
    "\0\u0af0\0\u0b28\0\u0b60\0\u0b98\0\u0bd0\0\u0c08\0\u0c40\0\u0c78"+
    "\0\u0620\0\70\0\70\0\u0cb0\0\u07a8\0\u0ce8\0\u0d20\0\u0d58"+
    "\0\u0d90\0\u0dc8\0\u0e00\0\u0e38\0\u0e70\0\u0ea8\0\u0ee0\0\u0310"+
    "\0\u0f18\0\u0310\0\u0f50\0\u0f88\0\u0fc0\0\u0ff8\0\u1030\0\u1068"+
    "\0\u10a0\0\u10d8\0\u1110\0\70\0\u0310\0\u1148\0\u0310\0\u0310"+
    "\0\u1180\0\u11b8\0\u11f0\0\u1228\0\u0310\0\u0310\0\u1260\0\u1298"+
    "\0\u0310\0\u12d0\0\u1308\0\u1340\0\u1378\0\u0310\0\u13b0\0\u0310"+
    "\0\u13e8\0\u0310\0\u1420\0\u1458\0\u1490\0\u14c8\0\u0310\0\u1500"+
    "\0\u1538\0\u1570\0\u15a8\0\u15e0\0\u1618\0\u0310\0\u1650\0\u1688"+
    "\0\u16c0\0\u0310\0\u16f8\0\u0310\0\u0310\0\u0310\0\u1730\0\u1768"+
    "\0\u17a0\0\u0310\0\u17d8\0\u1810\0\u0310\0\u0310\0\u0310\0\u0310"+
    "\0\u1848\0\u1880\0\u18b8\0\u18f0\0\u1928\0\u1960\0\u1998\0\u19d0"+
    "\0\u0310\0\u1a08\0\u1a40\0\u1a78\0\u1ab0\0\u1ae8\0\u0310\0\u1b20"+
    "\0\u0310";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[177];
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
    "\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\27"+
    "\1\36\3\27\1\37\4\27\1\40\1\41\1\42\1\27"+
    "\1\43\1\44\2\27\1\45\1\2\1\46\1\47\1\50"+
    "\1\51\1\52\71\0\1\3\2\0\1\3\111\0\1\53"+
    "\41\0\2\54\1\0\3\54\1\55\53\54\1\56\5\54"+
    "\10\0\1\57\57\0\2\60\1\0\3\60\1\0\53\60"+
    "\1\61\5\60\15\0\1\62\71\0\1\63\64\0\1\64"+
    "\4\0\1\65\66\0\1\66\1\0\1\21\73\0\1\67"+
    "\67\0\1\70\67\0\1\71\61\0\1\27\1\0\1\27"+
    "\5\0\31\27\3\0\1\27\23\0\1\27\1\0\1\27"+
    "\5\0\16\27\1\72\2\27\1\73\7\27\3\0\1\27"+
    "\23\0\1\27\1\0\1\27\5\0\1\74\6\27\1\75"+
    "\6\27\1\76\12\27\3\0\1\27\23\0\1\27\1\0"+
    "\1\27\5\0\4\27\1\77\11\27\1\100\12\27\3\0"+
    "\1\27\23\0\1\27\1\0\1\27\5\0\11\27\1\101"+
    "\1\27\1\102\15\27\3\0\1\27\23\0\1\27\1\0"+
    "\1\27\5\0\1\103\15\27\1\104\12\27\3\0\1\27"+
    "\23\0\1\27\1\0\1\27\5\0\21\27\1\105\7\27"+
    "\3\0\1\27\23\0\1\27\1\0\1\27\5\0\5\27"+
    "\1\106\7\27\1\107\13\27\3\0\1\27\23\0\1\27"+
    "\1\0\1\27\5\0\1\110\30\27\3\0\1\27\23\0"+
    "\1\27\1\0\1\27\5\0\4\27\1\111\24\27\3\0"+
    "\1\27\23\0\1\27\1\0\1\27\5\0\23\27\1\112"+
    "\2\27\1\113\2\27\3\0\1\27\23\0\1\27\1\0"+
    "\1\27\5\0\10\27\1\114\10\27\1\115\7\27\3\0"+
    "\1\27\23\0\1\27\1\0\1\27\5\0\1\116\15\27"+
    "\1\117\12\27\3\0\1\27\23\0\1\27\1\0\1\27"+
    "\5\0\7\27\1\120\21\27\3\0\1\27\33\0\31\27"+
    "\3\0\1\121\71\0\1\122\1\0\2\54\3\0\63\54"+
    "\11\0\1\123\56\0\2\60\3\0\63\60\14\64\1\124"+
    "\53\64\2\65\1\0\1\65\1\0\63\65\22\0\1\125"+
    "\65\0\1\27\1\0\1\27\5\0\16\27\1\126\12\27"+
    "\3\0\1\27\23\0\1\27\1\0\1\27\5\0\4\27"+
    "\1\127\24\27\3\0\1\27\23\0\1\27\1\0\1\27"+
    "\5\0\22\27\1\130\6\27\3\0\1\27\23\0\1\27"+
    "\1\0\1\27\5\0\1\131\30\27\3\0\1\27\23\0"+
    "\1\27\1\0\1\27\5\0\15\27\1\132\13\27\3\0"+
    "\1\27\23\0\1\27\1\0\1\27\5\0\5\27\1\133"+
    "\23\27\3\0\1\27\23\0\1\27\1\0\1\27\5\0"+
    "\24\27\1\134\4\27\3\0\1\27\23\0\1\27\1\0"+
    "\1\27\5\0\4\27\1\135\24\27\3\0\1\27\23\0"+
    "\1\27\1\0\1\27\5\0\22\27\1\136\6\27\3\0"+
    "\1\27\23\0\1\27\1\0\1\27\5\0\13\27\1\137"+
    "\15\27\3\0\1\27\23\0\1\27\1\0\1\27\5\0"+
    "\21\27\1\140\7\27\3\0\1\27\23\0\1\27\1\0"+
    "\1\27\5\0\1\141\30\27\3\0\1\27\23\0\1\27"+
    "\1\0\1\27\5\0\23\27\1\142\5\27\3\0\1\27"+
    "\23\0\1\27\1\0\1\27\5\0\10\27\1\143\20\27"+
    "\3\0\1\27\23\0\1\27\1\0\1\27\5\0\23\27"+
    "\1\144\5\27\3\0\1\27\23\0\1\27\1\0\1\27"+
    "\5\0\21\27\1\145\7\27\3\0\1\27\23\0\1\27"+
    "\1\0\1\27\5\0\10\27\1\146\20\27\3\0\1\27"+
    "\23\0\1\27\1\0\1\27\5\0\23\27\1\147\5\27"+
    "\3\0\1\27\23\0\1\27\1\0\1\27\5\0\24\27"+
    "\1\150\4\27\3\0\1\27\23\0\1\27\1\0\1\27"+
    "\5\0\13\27\1\151\15\27\3\0\1\27\23\0\1\27"+
    "\1\0\1\27\5\0\10\27\1\152\20\27\3\0\1\27"+
    "\23\0\1\27\1\0\1\27\5\0\10\27\1\153\20\27"+
    "\3\0\1\27\3\0\14\64\1\124\4\64\1\154\46\64"+
    "\20\0\1\27\1\0\1\27\5\0\13\27\1\155\15\27"+
    "\3\0\1\27\23\0\1\27\1\0\1\27\5\0\1\156"+
    "\30\27\3\0\1\27\23\0\1\27\1\0\1\27\5\0"+
    "\4\27\1\157\24\27\3\0\1\27\23\0\1\27\1\0"+
    "\1\27\5\0\21\27\1\160\7\27\3\0\1\27\23\0"+
    "\1\27\1\0\1\27\5\0\23\27\1\161\5\27\3\0"+
    "\1\27\23\0\1\27\1\0\1\27\5\0\1\162\7\27"+
    "\1\163\20\27\3\0\1\27\23\0\1\27\1\0\1\27"+
    "\5\0\1\27\1\164\27\27\3\0\1\27\23\0\1\27"+
    "\1\0\1\27\5\0\27\27\1\165\1\27\3\0\1\27"+
    "\23\0\1\27\1\0\1\27\5\0\4\27\1\166\24\27"+
    "\3\0\1\27\23\0\1\27\1\0\1\27\5\0\22\27"+
    "\1\167\6\27\3\0\1\27\23\0\1\27\1\0\1\27"+
    "\5\0\5\27\1\170\23\27\3\0\1\27\23\0\1\27"+
    "\1\0\1\27\5\0\15\27\1\171\13\27\3\0\1\27"+
    "\23\0\1\27\1\0\1\27\5\0\24\27\1\172\4\27"+
    "\3\0\1\27\23\0\1\27\1\0\1\27\5\0\10\27"+
    "\1\173\20\27\3\0\1\27\23\0\1\27\1\0\1\27"+
    "\5\0\23\27\1\174\5\27\3\0\1\27\23\0\1\27"+
    "\1\0\1\27\5\0\24\27\1\175\4\27\3\0\1\27"+
    "\23\0\1\27\1\0\1\27\5\0\4\27\1\176\24\27"+
    "\3\0\1\27\23\0\1\27\1\0\1\27\5\0\16\27"+
    "\1\177\12\27\3\0\1\27\23\0\1\27\1\0\1\27"+
    "\5\0\3\27\1\200\25\27\3\0\1\27\23\0\1\27"+
    "\1\0\1\27\5\0\13\27\1\201\15\27\3\0\1\27"+
    "\23\0\1\27\1\0\1\27\5\0\12\27\1\202\16\27"+
    "\3\0\1\27\23\0\1\27\1\0\1\27\5\0\10\27"+
    "\1\203\20\27\3\0\1\27\23\0\1\27\1\0\1\27"+
    "\5\0\24\27\1\204\4\27\3\0\1\27\23\0\1\27"+
    "\1\0\1\27\5\0\15\27\1\205\13\27\3\0\1\27"+
    "\23\0\1\27\1\0\1\27\5\0\13\27\1\206\15\27"+
    "\3\0\1\27\23\0\1\27\1\0\1\27\5\0\4\27"+
    "\1\207\24\27\3\0\1\27\23\0\1\27\1\0\1\27"+
    "\5\0\10\27\1\210\20\27\3\0\1\27\23\0\1\27"+
    "\1\0\1\27\5\0\21\27\1\211\7\27\3\0\1\27"+
    "\23\0\1\27\1\0\1\27\5\0\15\27\1\212\13\27"+
    "\3\0\1\27\23\0\1\27\1\0\1\27\5\0\2\27"+
    "\1\213\26\27\3\0\1\27\23\0\1\27\1\0\1\27"+
    "\5\0\13\27\1\214\15\27\3\0\1\27\23\0\1\27"+
    "\1\0\1\27\5\0\21\27\1\215\7\27\3\0\1\27"+
    "\23\0\1\27\1\0\1\27\5\0\4\27\1\216\24\27"+
    "\3\0\1\27\23\0\1\27\1\0\1\27\5\0\15\27"+
    "\1\217\13\27\3\0\1\27\23\0\1\27\1\0\1\27"+
    "\5\0\13\27\1\220\15\27\3\0\1\27\23\0\1\27"+
    "\1\0\1\27\5\0\10\27\1\221\20\27\3\0\1\27"+
    "\23\0\1\27\1\0\1\27\5\0\4\27\1\222\24\27"+
    "\3\0\1\27\23\0\1\27\1\0\1\27\5\0\2\27"+
    "\1\223\26\27\3\0\1\27\23\0\1\27\1\0\1\27"+
    "\5\0\15\27\1\224\13\27\3\0\1\27\23\0\1\27"+
    "\1\0\1\27\5\0\6\27\1\225\22\27\3\0\1\27"+
    "\23\0\1\27\1\0\1\27\5\0\7\27\1\226\21\27"+
    "\3\0\1\27\23\0\1\27\1\0\1\27\5\0\16\27"+
    "\1\227\12\27\3\0\1\27\23\0\1\27\1\0\1\27"+
    "\5\0\4\27\1\230\24\27\3\0\1\27\23\0\1\27"+
    "\1\0\1\27\5\0\24\27\1\231\4\27\3\0\1\27"+
    "\23\0\1\27\1\0\1\27\5\0\23\27\1\232\5\27"+
    "\3\0\1\27\23\0\1\27\1\0\1\27\5\0\21\27"+
    "\1\233\7\27\3\0\1\27\23\0\1\27\1\0\1\27"+
    "\5\0\1\234\30\27\3\0\1\27\23\0\1\27\1\0"+
    "\1\27\5\0\27\27\1\235\1\236\3\0\1\27\23\0"+
    "\1\27\1\0\1\27\5\0\22\27\1\237\6\27\3\0"+
    "\1\27\23\0\1\27\1\0\1\27\5\0\4\27\1\240"+
    "\24\27\3\0\1\27\23\0\1\27\1\0\1\27\5\0"+
    "\6\27\1\241\22\27\3\0\1\27\23\0\1\27\1\0"+
    "\1\27\5\0\1\27\1\242\15\27\1\243\11\27\3\0"+
    "\1\27\23\0\1\27\1\0\1\27\5\0\13\27\1\244"+
    "\15\27\3\0\1\27\23\0\1\27\1\0\1\27\5\0"+
    "\1\245\30\27\3\0\1\27\23\0\1\27\1\0\1\27"+
    "\5\0\10\27\1\246\20\27\3\0\1\27\23\0\1\27"+
    "\1\0\1\27\5\0\16\27\1\247\12\27\3\0\1\27"+
    "\23\0\1\27\1\0\1\27\5\0\21\27\1\250\7\27"+
    "\3\0\1\27\23\0\1\27\1\0\1\27\5\0\4\27"+
    "\1\251\24\27\3\0\1\27\23\0\1\27\1\0\1\27"+
    "\5\0\1\27\1\252\27\27\3\0\1\27\23\0\1\27"+
    "\1\0\1\27\5\0\21\27\1\253\7\27\3\0\1\27"+
    "\23\0\1\27\1\0\1\27\5\0\1\254\30\27\3\0"+
    "\1\27\23\0\1\27\1\0\1\27\5\0\1\255\30\27"+
    "\3\0\1\27\23\0\1\27\1\0\1\27\5\0\13\27"+
    "\1\256\15\27\3\0\1\27\23\0\1\27\1\0\1\27"+
    "\5\0\22\27\1\257\6\27\3\0\1\27\23\0\1\27"+
    "\1\0\1\27\5\0\4\27\1\260\24\27\3\0\1\27"+
    "\23\0\1\27\1\0\1\27\5\0\22\27\1\261\6\27"+
    "\3\0\1\27\3\0";

  private static int [] zzUnpacktrans() {
    int [] result = new int[7000];
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
    "\1\0\1\11\1\1\1\11\2\1\1\11\2\1\3\11"+
    "\1\1\1\11\3\1\2\11\21\1\2\11\1\1\1\11"+
    "\1\1\2\11\1\0\1\11\1\0\1\11\2\0\2\11"+
    "\1\0\1\1\1\0\3\11\27\1\1\0\2\11\1\0"+
    "\27\1\1\11\105\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[177];
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
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */
    private ArrayList<LexError> errors = new ArrayList<>();
    private void addError(String value){
        errors.add(new LexError(yyline, yycolumn, value));
    }

    public ArrayList<LexError> getErrors(){
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

      yychar+= zzMarkedPosL-zzStartRead;

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
          case 63: break;
          case 2:
            { 
            }
          // fall through
          case 64: break;
          case 3:
            { yycolumn = 0;
            }
          // fall through
          case 65: break;
          case 4:
            { return symbol(SYM.TK_NOT,          yytext());
            }
          // fall through
          case 66: break;
          case 5:
            { return symbol(SYM.TK_DOLL,         yytext());
            }
          // fall through
          case 67: break;
          case 6:
            { return symbol(SYM.TK_LPAR,         yytext());
            }
          // fall through
          case 68: break;
          case 7:
            { return symbol(SYM.TK_RPAR,         yytext());
            }
          // fall through
          case 69: break;
          case 8:
            { return symbol(SYM.TK_MULT,         yytext());
            }
          // fall through
          case 70: break;
          case 9:
            { return symbol(SYM.TK_PLUS,         yytext());
            }
          // fall through
          case 71: break;
          case 10:
            { return symbol(SYM.TK_COMA,         yytext());
            }
          // fall through
          case 72: break;
          case 11:
            { return symbol(SYM.TK_MINUS,        yytext());
            }
          // fall through
          case 73: break;
          case 12:
            { return symbol(SYM.TK_DIV,          yytext());
            }
          // fall through
          case 74: break;
          case 13:
            { return symbol(SYM.TK_INT,          yytext());
            }
          // fall through
          case 75: break;
          case 14:
            { return symbol(SYM.TK_COLON,        yytext());
            }
          // fall through
          case 76: break;
          case 15:
            { return symbol(SYM.TK_SCOLON,       yytext());
            }
          // fall through
          case 77: break;
          case 16:
            { return symbol(SYM.TK_LESS,         yytext());
            }
          // fall through
          case 78: break;
          case 17:
            { return symbol(SYM.TK_EQ,           yytext());
            }
          // fall through
          case 79: break;
          case 18:
            { return symbol(SYM.TK_GREATER,      yytext());
            }
          // fall through
          case 80: break;
          case 19:
            { return symbol(SYM.TK_ID,           yytext());
            }
          // fall through
          case 81: break;
          case 20:
            { return symbol(SYM.TK_LBRK,         yytext());
            }
          // fall through
          case 82: break;
          case 21:
            { return symbol(SYM.TK_RBRK,         yytext());
            }
          // fall through
          case 83: break;
          case 22:
            { return symbol(SYM.TK_LBRC,         yytext());
            }
          // fall through
          case 84: break;
          case 23:
            { return symbol(SYM.TK_RBRC,         yytext());
            }
          // fall through
          case 85: break;
          case 24:
            { return symbol(SYM.TK_NOTEQ,        yytext());
            }
          // fall through
          case 86: break;
          case 25:
            { return symbol(SYM.TK_STRING,       yytext());
            }
          // fall through
          case 87: break;
          case 26:
            { return symbol(SYM.TK_AND,          yytext());
            }
          // fall through
          case 88: break;
          case 27:
            { return symbol(SYM.TK_INC,          yytext());
            }
          // fall through
          case 89: break;
          case 28:
            { return symbol(SYM.TK_DEC,          yytext());
            }
          // fall through
          case 90: break;
          case 29:
            { return symbol(SYM.TK_LEQ,          yytext());
            }
          // fall through
          case 91: break;
          case 30:
            { return symbol(SYM.TK_EQEQ,         yytext());
            }
          // fall through
          case 92: break;
          case 31:
            { return symbol(SYM.TK_GEQ,          yytext());
            }
          // fall through
          case 93: break;
          case 32:
            { return symbol(SYM.KW_DO,           yytext());
            }
          // fall through
          case 94: break;
          case 33:
            { return symbol(SYM.KW_IF,           yytext());
            }
          // fall through
          case 95: break;
          case 34:
            { return symbol(SYM.TK_OR,           yytext());
            }
          // fall through
          case 96: break;
          case 35:
            { return symbol(SYM.TK_CHAR,         yytext());
            }
          // fall through
          case 97: break;
          case 36:
            { return symbol(SYM.TK_DOUBLE,       yytext());
            }
          // fall through
          case 98: break;
          case 37:
            { return symbol(SYM.KW_FOR,          yytext());
            }
          // fall through
          case 99: break;
          case 38:
            { return symbol(SYM.KW_INT,          yytext());
            }
          // fall through
          case 100: break;
          case 39:
            { return symbol(SYM.KW_BOOL,         yytext());
            }
          // fall through
          case 101: break;
          case 40:
            { return symbol(SYM.KW_CASE,         yytext());
            }
          // fall through
          case 102: break;
          case 41:
            { return symbol(SYM.KW_CHAR,         yytext());
            }
          // fall through
          case 103: break;
          case 42:
            { return symbol(SYM.KW_XAXIS,        yytext());
            }
          // fall through
          case 104: break;
          case 43:
            { return symbol(SYM.KW_ELSE,         yytext());
            }
          // fall through
          case 105: break;
          case 44:
            { return symbol(SYM.KW_MAIN,         yytext());
            }
          // fall through
          case 106: break;
          case 45:
            { return symbol(SYM.KW_TRUE,         yytext());
            }
          // fall through
          case 107: break;
          case 46:
            { return symbol(SYM.KW_VOID,         yytext());
            }
          // fall through
          case 108: break;
          case 47:
            { return symbol(SYM.KW_BREAK,        yytext());
            }
          // fall through
          case 109: break;
          case 48:
            { return symbol(SYM.KW_FALSE,        yytext());
            }
          // fall through
          case 110: break;
          case 49:
            { return symbol(SYM.KW_WHILE,        yytext());
            }
          // fall through
          case 111: break;
          case 50:
            { return symbol(SYM.KW_DOUBLE,       yytext());
            }
          // fall through
          case 112: break;
          case 51:
            { return symbol(SYM.KW_RETURN,       yytext());
            }
          // fall through
          case 113: break;
          case 52:
            { return symbol(SYM.KW_STRING,       yytext());
            }
          // fall through
          case 114: break;
          case 53:
            { return symbol(SYM.KW_SWITCH,       yytext());
            }
          // fall through
          case 115: break;
          case 54:
            { return symbol(SYM.KW_TITLE,        yytext());
            }
          // fall through
          case 116: break;
          case 55:
            { return symbol(SYM.KW_DEFAULT,      yytext());
            }
          // fall through
          case 117: break;
          case 56:
            { return symbol(SYM.KW_TITLEX,       yytext());
            }
          // fall through
          case 118: break;
          case 57:
            { return symbol(SYM.KW_TITLEY,       yytext());
            }
          // fall through
          case 119: break;
          case 58:
            { return symbol(SYM.KW_VALUES,       yytext());
            }
          // fall through
          case 120: break;
          case 59:
            { return symbol(SYM.KW_CONTINUE,     yytext());
            }
          // fall through
          case 121: break;
          case 60:
            { return symbol(SYM.KW_PIEGRPH,      yytext());
            }
          // fall through
          case 122: break;
          case 61:
            { return symbol(SYM.KW_BARGRPH,      yytext());
            }
          // fall through
          case 123: break;
          case 62:
            { return symbol(SYM.KW_DEFGLB,       yytext());
            }
          // fall through
          case 124: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
