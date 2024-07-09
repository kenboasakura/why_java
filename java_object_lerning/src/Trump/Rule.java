package Trump;

/*インタフェース名:Rule
*概要:ルールを管理
*作成者:K.Asakura
*作成日:2024/07/03
*/
public interface Rule {
	
	/*関数名:findCandidate
	 *概要:テーブルに置けるカードを探す
	 *引数:自分の手札(Handクラス)、ゲーム中のテーブル(Tableインタフェース)
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public Card[] findCandidate(Hand playerHand,Table gametTable);

}
