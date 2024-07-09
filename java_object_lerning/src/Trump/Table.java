package Trump;

/*インタフェース名:Table
*概要:テーブルを管理
*作成者:K.Asakura
*作成日:2024/07/03
*/
public interface Table {

	/*関数名:putCard
	 *概要:カードを置く
	 *引数:カード(Card型の配列)
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public void putCard(Card[] cardNumber);

	/*関数名:getCards
	 *概要:カードを取得する
	 *引数:なし
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public Card[][] getCards();

}