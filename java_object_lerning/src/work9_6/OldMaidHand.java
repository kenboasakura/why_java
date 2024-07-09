package work9_6;

//TrumpパッケージのCardクラスをインポート
import Trump.Card;
//TrumpパッケージのHandクラスをインポート
import Trump.Hand;

/*クラス名:OldMaidHand
 *概要:ばば抜きの手札を管理
 *作成者:K.Asakura
 *作成日:2024/07/03
 */
public class OldMaidHand{
	//手札を表すHand型のインスタンスを生成
	private Hand myHand = new Hand();
	
	/*コンストラクタ名:OldMaidHand
	 *概要:フィールドを仮引数で初期化
	 *引数:手札(Handクラス)
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public OldMaidHand(Hand myHand){
		//手札を表すフィールドを仮引数で初期化
		this.myHand = myHand;
	}
	
	/*関数名:pickCard
	 *概要:カードを引く
	 *引数:なし
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public Card pickCard(int cardPosition) {
		//引かれるカードを返却
		return myHand.pickCard(cardPosition);
	}

}
