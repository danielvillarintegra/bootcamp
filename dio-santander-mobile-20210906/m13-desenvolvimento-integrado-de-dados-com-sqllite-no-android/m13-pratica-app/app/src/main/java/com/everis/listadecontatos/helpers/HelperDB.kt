package com.everis.listadecontatos.helpers

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.everis.listadecontatos.feature.listacontatos.model.ContatosVO

// tem que herdar a classe SQLiteOpenHelper
class HelperDB(
    context: Context?

) : SQLiteOpenHelper(context, NOME_BANCO, null, VERSAO_ATUAL) {

    companion object {
        private val NOME_BANCO = "contato.db"
        private val VERSAO_ATUAL = 4
    }
    val TABLE_NAME = "contato"
    val COLUMNS_ID = "id"
    val COLUMNS_NOME = "nome"
    val COLUMNS_TELEFONE = "telefone"

    val DROP_TABLE = """DROP TABLE IF EXISTS $TABLE_NAME"""

    val CREATE_TABLE = "CREATE TABLE $TABLE_NAME (" +
                            "$COLUMNS_ID INTEGER NOT NULL," +
                            "$COLUMNS_NOME TEXT NOT NULL," +
                            "$COLUMNS_TELEFONE TEXT NOT NULL," +
                        "" +
                        "PRIMARY KEY($COLUMNS_ID AUTOINCREMENT)" +
                        ")"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE)
    }

// Atualiza a tabela ao mudar a versão , isto é, qualquer alteração na estrutura da tabela
    override fun onUpgrade(db: SQLiteDatabase?,oldVersion: Int, newVersion: Int) {
        if(oldVersion != newVersion){
            db?.execSQL(DROP_TABLE)
        }
        onCreate(db)
    }

    fun buscarContatos(busca: String) : List<ContatosVO> {
        val db = readableDatabase ?: return mutableListOf() // Elvis: se o DataBase for nulo retorna um tipo mutableListOf() vazio
        var lista = mutableListOf<ContatosVO>()
        val sql = "SELECT * FROM $TABLE_NAME WHERE $COLUMNS_NOME LIKE '%$busca%'"
        val buscaComPercentual = "%$busca%"
        var cursor = db.rawQuery(sql, arrayOf())  // ?: return mutableListOf() se usar Elvis: se o DataBase for nulo não faz nada, mas retorna um tipo mutableListOf() vazio
        if (cursor == null){
            db.close()
            return mutableListOf()
        }

        while (cursor.moveToNext()) {
            var contato = ContatosVO(
                cursor.getInt(cursor.getColumnIndex(COLUMNS_ID)),	/* De Para */
                cursor.getString(cursor.getColumnIndex(COLUMNS_NOME)),	/* De Para */
                cursor.getString(cursor.getColumnIndex(COLUMNS_TELEFONE))	/* De Para */
            )
            lista.add(contato)
        }
        db.close()
        return lista
    }
/* Terceira maneira de fazer INSERT */
    fun salvarContato(contato: ContatosVO) {
        var db = writableDatabase ?: return
        var content = ContentValues()
        content.put(COLUMNS_NOME,contato.nome)
        content.put(COLUMNS_TELEFONE,contato.telefone)
        db.insert(TABLE_NAME, null, content)
        db.close()
    }

/* Primeira maneira de fazer INSERT
    fun salvarContato(contato: ContatosVO) {
        var db = writableDatabase ?: return
        val sql = "INSERT INTO $TABLE_NAME ($COLUMNS_NOME,$COLUMNS_TELEFONE) VALUES ('TESTE','TESTE')"
        db.execSQL(sql)
        db.close()
    }

 */

 /* Segunda maneira de fazer INSERT
    fun salvarContato(contato: ContatosVO) {
        var db = writableDatabase ?: return

        val sql = "INSERT INTO $TABLE_NAME ($COLUMNS_NOME,$COLUMNS_TELEFONE) VALUES (?,?)"
        var array = arrayOf(contato.nome, contato.telefone)
        db.execSQL(sql, array)
        db.close()
}
*/

}
