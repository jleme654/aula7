package com.example;

import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_principal, menu);
		return true;
	}

	public void getMenuSelecionado(String msg) {
		TextView status = (TextView) findViewById(R.id.mStatus);
		status.setText(msg);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
//		case R.id.menu_add:
//			getMenuSelecionado("Adicionar Contato Selecionado");
//			return true;
		case R.id.menu_friendslist:
			getMenuSelecionado("Lista de Contatos");
			return true;
		case R.id.menu_search:
			AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
			dialogo.setMessage("Menu Busca Contato selecionado");
			dialogo.setTitle("Buscar Contato");
			dialogo.setIcon(R.drawable.ic_menu_search);
			dialogo.setNeutralButton("OK", null);
			dialogo.show();
			return true;
		case R.id.menu_close_clear_cancel:
//			getMenuSelecionado("Opção fechar selecionado");
			fecharAtividade();
			return true;
		default:
//			getMenuSelecionado("Outro menu selecionado");
			return false;
		}
	}

	public void fecharAtividade() {
		AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
		dialogo.setMessage("Deseja encerrar?");
		dialogo.setPositiveButton("Sim", new OnClickListener() {		
			public void onClick(DialogInterface dialog, int which) {
				finish();
			}
		});
	    dialogo.setNegativeButton("Nao", new OnClickListener() {		
			public void onClick(DialogInterface dialog, int which) {
				TextView status = (TextView) findViewById(R.id.mStatus);
				status.setText("Botao nao selecionado");
			}
		});	
	    dialogo.setTitle("Fechar atividade");
	    dialogo.setIcon(R.drawable.ic_menu_info_details);
	    dialogo.show();
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container, false);
			return rootView;
		}
	}

}
