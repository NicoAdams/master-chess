package dtadams.chess.gui;

import dtadams.chess.*;
import dtadams.chess.piece.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;

public class ChessPanel
	extends Container {

	int width,
		height,
		boardWidth,
		boardHeight,
		horzBorder,
		vertBorder;

	PieceColor view;
	PieceColor currentPlayer;

	ChessBoard cb;

	public ChessPanel(int _width, int _height, int _squareSize, Board _b) {
		super();
		setPreferredSize(new Dimension(_width, _height));

		this.width = _width;
		this.height = _height;

		this.boardWidth = _squareSize * _b.getCols();
		this.boardHeight = _squareSize * _b.getRows();
		this.horzBorder = (width - boardWidth) / 2;
		this.vertBorder = (height - boardHeight) / 2;

		this.view = PieceColor.WHITE;
		this.currentPlayer = PieceColor.NONE;

		this.cb = new ChessBoard(_squareSize, _b, horzBorder, vertBorder);
		cb.setBounds(horzBorder, vertBorder, boardWidth, boardHeight);
		cb.setView(view);
		cb.setCurrentPlayer(currentPlayer);
		this.add(cb);

	}

	public ChessBoard getBoard() {
		return cb;
	}

	public void paint(Graphics g0) {
		Graphics2D g = (Graphics2D)g0;

		g.drawImage(ImageLoader.getBackground(),
					0,
					0,
					width,
					height,
					null);

		cb.paint(g);
	}
}
