// Generated from c:/Projects/journey/command/src/main/antlr/net/whimxiqal/journey/command/Journey.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class JourneyParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ADMIN=1, BUILD=2, CACHE=3, CANCEL=4, CLEAR=5, COLON=6, DEBUG=7, FALSE=8, 
		INVALIDATE=9, JOURNEY=10, JOURNEY_TO=11, LIST_NETHER_PORTALS=12, LIST_WAYPOINTS=13, 
		PATH=14, PATHS=15, PLAYER=16, PORTALS=17, PUBLIC=18, RELOAD=19, RENAME=20, 
		SERVER=21, SET=22, SET_WAYPOINT=23, TRUE=24, UNSET=25, WAYPOINT=26, FLAG_ANIMATE=27, 
		FLAG_DIG=28, FLAG_DOOR=29, FLAG_FLY=30, FLAG_NAVIGATOR=31, FLAG_TIMEOUT=32, 
		OPEN_BRACE=33, CLOSED_BRACE=34, ID=35, SINGLE_QUOTE=36, DOUBLE_QUOTE=37, 
		WS=38;
	public static final int
		RULE_journey = 0, RULE_journeyto = 1, RULE_setwaypoint = 2, RULE_listwaypoints = 3, 
		RULE_listwaypointsMine = 4, RULE_listwaypointsPlayer = 5, RULE_waypoint = 6, 
		RULE_unsetWaypoint = 7, RULE_renameWaypoint = 8, RULE_publicWaypoint = 9, 
		RULE_player = 10, RULE_playerWaypoint = 11, RULE_server = 12, RULE_serverSetWaypoint = 13, 
		RULE_serverListWaypoints = 14, RULE_serverWaypoint = 15, RULE_serverUnsetWaypoint = 16, 
		RULE_serverRenameWaypoint = 17, RULE_admin = 18, RULE_debug = 19, RULE_cache = 20, 
		RULE_cachePortals = 21, RULE_cachePaths = 22, RULE_listNetherPortals = 23, 
		RULE_cancel = 24, RULE_journeytoTarget = 25, RULE_flagSet = 26, RULE_timeoutFlag = 27, 
		RULE_animateFlag = 28, RULE_flyFlag = 29, RULE_doorFlag = 30, RULE_digFlag = 31, 
		RULE_navigatorFlag = 32, RULE_identifier = 33, RULE_ident = 34;
	private static String[] makeRuleNames() {
		return new String[] {
			"journey", "journeyto", "setwaypoint", "listwaypoints", "listwaypointsMine", 
			"listwaypointsPlayer", "waypoint", "unsetWaypoint", "renameWaypoint", 
			"publicWaypoint", "player", "playerWaypoint", "server", "serverSetWaypoint", 
			"serverListWaypoints", "serverWaypoint", "serverUnsetWaypoint", "serverRenameWaypoint", 
			"admin", "debug", "cache", "cachePortals", "cachePaths", "listNetherPortals", 
			"cancel", "journeytoTarget", "flagSet", "timeoutFlag", "animateFlag", 
			"flyFlag", "doorFlag", "digFlag", "navigatorFlag", "identifier", "ident"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'admin'", "'build'", "'cache'", "'cancel'", "'clear'", "':'", 
			"'debug'", "'false'", "'invalidate'", "'journey'", "'journeyto'", "'listnetherportals'", 
			"'listwaypoints'", "'path'", "'paths'", "'player'", "'portals'", "'public'", 
			"'reload'", "'rename'", "'server'", "'set'", "'setwaypoint'", "'true'", 
			"'unset'", "'waypoint'", "'-animate'", "'-dig'", "'-door'", "'-fly'", 
			"'-navigator'", "'-timeout'", "'{'", "'}'", null, "'''", "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ADMIN", "BUILD", "CACHE", "CANCEL", "CLEAR", "COLON", "DEBUG", 
			"FALSE", "INVALIDATE", "JOURNEY", "JOURNEY_TO", "LIST_NETHER_PORTALS", 
			"LIST_WAYPOINTS", "PATH", "PATHS", "PLAYER", "PORTALS", "PUBLIC", "RELOAD", 
			"RENAME", "SERVER", "SET", "SET_WAYPOINT", "TRUE", "UNSET", "WAYPOINT", 
			"FLAG_ANIMATE", "FLAG_DIG", "FLAG_DOOR", "FLAG_FLY", "FLAG_NAVIGATOR", 
			"FLAG_TIMEOUT", "OPEN_BRACE", "CLOSED_BRACE", "ID", "SINGLE_QUOTE", "DOUBLE_QUOTE", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Journey.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JourneyParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JourneyContext extends ParserRuleContext {
		public TerminalNode JOURNEY() { return getToken(JourneyParser.JOURNEY, 0); }
		public TerminalNode EOF() { return getToken(JourneyParser.EOF, 0); }
		public SetwaypointContext setwaypoint() {
			return getRuleContext(SetwaypointContext.class,0);
		}
		public ListwaypointsContext listwaypoints() {
			return getRuleContext(ListwaypointsContext.class,0);
		}
		public WaypointContext waypoint() {
			return getRuleContext(WaypointContext.class,0);
		}
		public PlayerContext player() {
			return getRuleContext(PlayerContext.class,0);
		}
		public ServerContext server() {
			return getRuleContext(ServerContext.class,0);
		}
		public AdminContext admin() {
			return getRuleContext(AdminContext.class,0);
		}
		public CancelContext cancel() {
			return getRuleContext(CancelContext.class,0);
		}
		public JourneyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_journey; }
	}

	public final JourneyContext journey() throws RecognitionException {
		JourneyContext _localctx = new JourneyContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_journey);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(JOURNEY);
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SET_WAYPOINT:
				{
				setState(71);
				setwaypoint();
				}
				break;
			case LIST_WAYPOINTS:
				{
				setState(72);
				listwaypoints();
				}
				break;
			case WAYPOINT:
				{
				setState(73);
				waypoint();
				}
				break;
			case PLAYER:
				{
				setState(74);
				player();
				}
				break;
			case SERVER:
				{
				setState(75);
				server();
				}
				break;
			case ADMIN:
				{
				setState(76);
				admin();
				}
				break;
			case CANCEL:
				{
				setState(77);
				cancel();
				}
				break;
			case EOF:
				break;
			default:
				break;
			}
			setState(80);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JourneytoContext extends ParserRuleContext {
		public TerminalNode JOURNEY_TO() { return getToken(JourneyParser.JOURNEY_TO, 0); }
		public TerminalNode EOF() { return getToken(JourneyParser.EOF, 0); }
		public JourneytoTargetContext journeytoTarget() {
			return getRuleContext(JourneytoTargetContext.class,0);
		}
		public JourneytoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_journeyto; }
	}

	public final JourneytoContext journeyto() throws RecognitionException {
		JourneytoContext _localctx = new JourneytoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_journeyto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(JOURNEY_TO);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 240652222398L) != 0)) {
				{
				setState(83);
				journeytoTarget();
				}
			}

			setState(86);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SetwaypointContext extends ParserRuleContext {
		public IdentifierContext name;
		public TerminalNode SET_WAYPOINT() { return getToken(JourneyParser.SET_WAYPOINT, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public SetwaypointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setwaypoint; }
	}

	public final SetwaypointContext setwaypoint() throws RecognitionException {
		SetwaypointContext _localctx = new SetwaypointContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_setwaypoint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(SET_WAYPOINT);
			setState(90); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(89);
				((SetwaypointContext)_localctx).name = identifier();
				}
				}
				setState(92); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 240652222398L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListwaypointsContext extends ParserRuleContext {
		public TerminalNode LIST_WAYPOINTS() { return getToken(JourneyParser.LIST_WAYPOINTS, 0); }
		public ListwaypointsMineContext listwaypointsMine() {
			return getRuleContext(ListwaypointsMineContext.class,0);
		}
		public ListwaypointsPlayerContext listwaypointsPlayer() {
			return getRuleContext(ListwaypointsPlayerContext.class,0);
		}
		public ListwaypointsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listwaypoints; }
	}

	public final ListwaypointsContext listwaypoints() throws RecognitionException {
		ListwaypointsContext _localctx = new ListwaypointsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_listwaypoints);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(LIST_WAYPOINTS);
			setState(97);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
			case ID:
				{
				setState(95);
				listwaypointsMine();
				}
				break;
			case PLAYER:
				{
				setState(96);
				listwaypointsPlayer();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListwaypointsMineContext extends ParserRuleContext {
		public Token page;
		public TerminalNode ID() { return getToken(JourneyParser.ID, 0); }
		public ListwaypointsMineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listwaypointsMine; }
	}

	public final ListwaypointsMineContext listwaypointsMine() throws RecognitionException {
		ListwaypointsMineContext _localctx = new ListwaypointsMineContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_listwaypointsMine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(99);
				((ListwaypointsMineContext)_localctx).page = match(ID);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListwaypointsPlayerContext extends ParserRuleContext {
		public IdentifierContext user;
		public Token page;
		public PlayerContext player() {
			return getRuleContext(PlayerContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ID() { return getToken(JourneyParser.ID, 0); }
		public ListwaypointsPlayerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listwaypointsPlayer; }
	}

	public final ListwaypointsPlayerContext listwaypointsPlayer() throws RecognitionException {
		ListwaypointsPlayerContext _localctx = new ListwaypointsPlayerContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_listwaypointsPlayer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			player();
			setState(103);
			((ListwaypointsPlayerContext)_localctx).user = identifier();
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(104);
				((ListwaypointsPlayerContext)_localctx).page = match(ID);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WaypointContext extends ParserRuleContext {
		public IdentifierContext name;
		public TerminalNode WAYPOINT() { return getToken(JourneyParser.WAYPOINT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public UnsetWaypointContext unsetWaypoint() {
			return getRuleContext(UnsetWaypointContext.class,0);
		}
		public RenameWaypointContext renameWaypoint() {
			return getRuleContext(RenameWaypointContext.class,0);
		}
		public PublicWaypointContext publicWaypoint() {
			return getRuleContext(PublicWaypointContext.class,0);
		}
		public FlagSetContext flagSet() {
			return getRuleContext(FlagSetContext.class,0);
		}
		public WaypointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_waypoint; }
	}

	public final WaypointContext waypoint() throws RecognitionException {
		WaypointContext _localctx = new WaypointContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_waypoint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(WAYPOINT);
			setState(108);
			((WaypointContext)_localctx).name = identifier();
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNSET:
				{
				setState(109);
				unsetWaypoint();
				}
				break;
			case RENAME:
				{
				setState(110);
				renameWaypoint();
				}
				break;
			case PUBLIC:
				{
				setState(111);
				publicWaypoint();
				}
				break;
			case FLAG_ANIMATE:
			case FLAG_DIG:
			case FLAG_DOOR:
			case FLAG_FLY:
			case FLAG_NAVIGATOR:
			case FLAG_TIMEOUT:
				{
				setState(112);
				flagSet();
				}
				break;
			case EOF:
				break;
			default:
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnsetWaypointContext extends ParserRuleContext {
		public TerminalNode UNSET() { return getToken(JourneyParser.UNSET, 0); }
		public UnsetWaypointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsetWaypoint; }
	}

	public final UnsetWaypointContext unsetWaypoint() throws RecognitionException {
		UnsetWaypointContext _localctx = new UnsetWaypointContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_unsetWaypoint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(UNSET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RenameWaypointContext extends ParserRuleContext {
		public IdentifierContext newname;
		public TerminalNode RENAME() { return getToken(JourneyParser.RENAME, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public RenameWaypointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_renameWaypoint; }
	}

	public final RenameWaypointContext renameWaypoint() throws RecognitionException {
		RenameWaypointContext _localctx = new RenameWaypointContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_renameWaypoint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(RENAME);
			setState(118);
			((RenameWaypointContext)_localctx).newname = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PublicWaypointContext extends ParserRuleContext {
		public TerminalNode PUBLIC() { return getToken(JourneyParser.PUBLIC, 0); }
		public TerminalNode TRUE() { return getToken(JourneyParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(JourneyParser.FALSE, 0); }
		public PublicWaypointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_publicWaypoint; }
	}

	public final PublicWaypointContext publicWaypoint() throws RecognitionException {
		PublicWaypointContext _localctx = new PublicWaypointContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_publicWaypoint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(PUBLIC);
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FALSE || _la==TRUE) {
				{
				setState(121);
				_la = _input.LA(1);
				if ( !(_la==FALSE || _la==TRUE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PlayerContext extends ParserRuleContext {
		public IdentifierContext user;
		public TerminalNode PLAYER() { return getToken(JourneyParser.PLAYER, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public PlayerWaypointContext playerWaypoint() {
			return getRuleContext(PlayerWaypointContext.class,0);
		}
		public PlayerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_player; }
	}

	public final PlayerContext player() throws RecognitionException {
		PlayerContext _localctx = new PlayerContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_player);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(PLAYER);
			setState(125);
			((PlayerContext)_localctx).user = identifier();
			setState(127);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(126);
				playerWaypoint();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PlayerWaypointContext extends ParserRuleContext {
		public IdentifierContext name;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public PlayerWaypointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_playerWaypoint; }
	}

	public final PlayerWaypointContext playerWaypoint() throws RecognitionException {
		PlayerWaypointContext _localctx = new PlayerWaypointContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_playerWaypoint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			((PlayerWaypointContext)_localctx).name = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ServerContext extends ParserRuleContext {
		public TerminalNode SERVER() { return getToken(JourneyParser.SERVER, 0); }
		public ServerSetWaypointContext serverSetWaypoint() {
			return getRuleContext(ServerSetWaypointContext.class,0);
		}
		public ServerListWaypointsContext serverListWaypoints() {
			return getRuleContext(ServerListWaypointsContext.class,0);
		}
		public ServerWaypointContext serverWaypoint() {
			return getRuleContext(ServerWaypointContext.class,0);
		}
		public ServerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_server; }
	}

	public final ServerContext server() throws RecognitionException {
		ServerContext _localctx = new ServerContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_server);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(SERVER);
			setState(135);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SET_WAYPOINT:
				{
				setState(132);
				serverSetWaypoint();
				}
				break;
			case LIST_WAYPOINTS:
				{
				setState(133);
				serverListWaypoints();
				}
				break;
			case WAYPOINT:
				{
				setState(134);
				serverWaypoint();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ServerSetWaypointContext extends ParserRuleContext {
		public IdentifierContext name;
		public TerminalNode SET_WAYPOINT() { return getToken(JourneyParser.SET_WAYPOINT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ServerSetWaypointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serverSetWaypoint; }
	}

	public final ServerSetWaypointContext serverSetWaypoint() throws RecognitionException {
		ServerSetWaypointContext _localctx = new ServerSetWaypointContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_serverSetWaypoint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(SET_WAYPOINT);
			setState(138);
			((ServerSetWaypointContext)_localctx).name = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ServerListWaypointsContext extends ParserRuleContext {
		public Token page;
		public TerminalNode LIST_WAYPOINTS() { return getToken(JourneyParser.LIST_WAYPOINTS, 0); }
		public TerminalNode ID() { return getToken(JourneyParser.ID, 0); }
		public ServerListWaypointsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serverListWaypoints; }
	}

	public final ServerListWaypointsContext serverListWaypoints() throws RecognitionException {
		ServerListWaypointsContext _localctx = new ServerListWaypointsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_serverListWaypoints);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(LIST_WAYPOINTS);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(141);
				((ServerListWaypointsContext)_localctx).page = match(ID);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ServerWaypointContext extends ParserRuleContext {
		public IdentifierContext name;
		public TerminalNode WAYPOINT() { return getToken(JourneyParser.WAYPOINT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ServerUnsetWaypointContext serverUnsetWaypoint() {
			return getRuleContext(ServerUnsetWaypointContext.class,0);
		}
		public ServerRenameWaypointContext serverRenameWaypoint() {
			return getRuleContext(ServerRenameWaypointContext.class,0);
		}
		public FlagSetContext flagSet() {
			return getRuleContext(FlagSetContext.class,0);
		}
		public ServerWaypointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serverWaypoint; }
	}

	public final ServerWaypointContext serverWaypoint() throws RecognitionException {
		ServerWaypointContext _localctx = new ServerWaypointContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_serverWaypoint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(WAYPOINT);
			setState(145);
			((ServerWaypointContext)_localctx).name = identifier();
			setState(149);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNSET:
				{
				setState(146);
				serverUnsetWaypoint();
				}
				break;
			case RENAME:
				{
				setState(147);
				serverRenameWaypoint();
				}
				break;
			case FLAG_ANIMATE:
			case FLAG_DIG:
			case FLAG_DOOR:
			case FLAG_FLY:
			case FLAG_NAVIGATOR:
			case FLAG_TIMEOUT:
				{
				setState(148);
				flagSet();
				}
				break;
			case EOF:
				break;
			default:
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ServerUnsetWaypointContext extends ParserRuleContext {
		public TerminalNode UNSET() { return getToken(JourneyParser.UNSET, 0); }
		public ServerUnsetWaypointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serverUnsetWaypoint; }
	}

	public final ServerUnsetWaypointContext serverUnsetWaypoint() throws RecognitionException {
		ServerUnsetWaypointContext _localctx = new ServerUnsetWaypointContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_serverUnsetWaypoint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(UNSET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ServerRenameWaypointContext extends ParserRuleContext {
		public IdentifierContext newname;
		public TerminalNode RENAME() { return getToken(JourneyParser.RENAME, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ServerRenameWaypointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serverRenameWaypoint; }
	}

	public final ServerRenameWaypointContext serverRenameWaypoint() throws RecognitionException {
		ServerRenameWaypointContext _localctx = new ServerRenameWaypointContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_serverRenameWaypoint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(RENAME);
			setState(154);
			((ServerRenameWaypointContext)_localctx).newname = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AdminContext extends ParserRuleContext {
		public Token reload;
		public TerminalNode ADMIN() { return getToken(JourneyParser.ADMIN, 0); }
		public DebugContext debug() {
			return getRuleContext(DebugContext.class,0);
		}
		public CacheContext cache() {
			return getRuleContext(CacheContext.class,0);
		}
		public ListNetherPortalsContext listNetherPortals() {
			return getRuleContext(ListNetherPortalsContext.class,0);
		}
		public TerminalNode RELOAD() { return getToken(JourneyParser.RELOAD, 0); }
		public AdminContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_admin; }
	}

	public final AdminContext admin() throws RecognitionException {
		AdminContext _localctx = new AdminContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_admin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(ADMIN);
			setState(161);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DEBUG:
				{
				setState(157);
				debug();
				}
				break;
			case CACHE:
				{
				setState(158);
				cache();
				}
				break;
			case RELOAD:
				{
				setState(159);
				((AdminContext)_localctx).reload = match(RELOAD);
				}
				break;
			case LIST_NETHER_PORTALS:
				{
				setState(160);
				listNetherPortals();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DebugContext extends ParserRuleContext {
		public TerminalNode DEBUG() { return getToken(JourneyParser.DEBUG, 0); }
		public DebugContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_debug; }
	}

	public final DebugContext debug() throws RecognitionException {
		DebugContext _localctx = new DebugContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_debug);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(DEBUG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CacheContext extends ParserRuleContext {
		public TerminalNode CACHE() { return getToken(JourneyParser.CACHE, 0); }
		public CachePortalsContext cachePortals() {
			return getRuleContext(CachePortalsContext.class,0);
		}
		public CachePathsContext cachePaths() {
			return getRuleContext(CachePathsContext.class,0);
		}
		public CacheContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cache; }
	}

	public final CacheContext cache() throws RecognitionException {
		CacheContext _localctx = new CacheContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_cache);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(CACHE);
			setState(168);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PORTALS:
				{
				setState(166);
				cachePortals();
				}
				break;
			case PATHS:
				{
				setState(167);
				cachePaths();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CachePortalsContext extends ParserRuleContext {
		public Token clear;
		public TerminalNode PORTALS() { return getToken(JourneyParser.PORTALS, 0); }
		public TerminalNode CLEAR() { return getToken(JourneyParser.CLEAR, 0); }
		public CachePortalsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cachePortals; }
	}

	public final CachePortalsContext cachePortals() throws RecognitionException {
		CachePortalsContext _localctx = new CachePortalsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_cachePortals);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(PORTALS);
			{
			setState(171);
			((CachePortalsContext)_localctx).clear = match(CLEAR);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CachePathsContext extends ParserRuleContext {
		public Token clear;
		public Token build;
		public TerminalNode PATHS() { return getToken(JourneyParser.PATHS, 0); }
		public TerminalNode CLEAR() { return getToken(JourneyParser.CLEAR, 0); }
		public TerminalNode BUILD() { return getToken(JourneyParser.BUILD, 0); }
		public CachePathsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cachePaths; }
	}

	public final CachePathsContext cachePaths() throws RecognitionException {
		CachePathsContext _localctx = new CachePathsContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_cachePaths);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(PATHS);
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLEAR:
				{
				setState(174);
				((CachePathsContext)_localctx).clear = match(CLEAR);
				}
				break;
			case BUILD:
				{
				setState(175);
				((CachePathsContext)_localctx).build = match(BUILD);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListNetherPortalsContext extends ParserRuleContext {
		public Token page;
		public TerminalNode LIST_NETHER_PORTALS() { return getToken(JourneyParser.LIST_NETHER_PORTALS, 0); }
		public TerminalNode ID() { return getToken(JourneyParser.ID, 0); }
		public ListNetherPortalsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listNetherPortals; }
	}

	public final ListNetherPortalsContext listNetherPortals() throws RecognitionException {
		ListNetherPortalsContext _localctx = new ListNetherPortalsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_listNetherPortals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(LIST_NETHER_PORTALS);
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(179);
				((ListNetherPortalsContext)_localctx).page = match(ID);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CancelContext extends ParserRuleContext {
		public TerminalNode CANCEL() { return getToken(JourneyParser.CANCEL, 0); }
		public CancelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cancel; }
	}

	public final CancelContext cancel() throws RecognitionException {
		CancelContext _localctx = new CancelContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_cancel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(CANCEL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JourneytoTargetContext extends ParserRuleContext {
		public IdentifierContext name;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FlagSetContext flagSet() {
			return getRuleContext(FlagSetContext.class,0);
		}
		public JourneytoTargetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_journeytoTarget; }
	}

	public final JourneytoTargetContext journeytoTarget() throws RecognitionException {
		JourneytoTargetContext _localctx = new JourneytoTargetContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_journeytoTarget);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			((JourneytoTargetContext)_localctx).name = identifier();
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8455716864L) != 0)) {
				{
				setState(185);
				flagSet();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FlagSetContext extends ParserRuleContext {
		public List<TimeoutFlagContext> timeoutFlag() {
			return getRuleContexts(TimeoutFlagContext.class);
		}
		public TimeoutFlagContext timeoutFlag(int i) {
			return getRuleContext(TimeoutFlagContext.class,i);
		}
		public List<AnimateFlagContext> animateFlag() {
			return getRuleContexts(AnimateFlagContext.class);
		}
		public AnimateFlagContext animateFlag(int i) {
			return getRuleContext(AnimateFlagContext.class,i);
		}
		public List<FlyFlagContext> flyFlag() {
			return getRuleContexts(FlyFlagContext.class);
		}
		public FlyFlagContext flyFlag(int i) {
			return getRuleContext(FlyFlagContext.class,i);
		}
		public List<DoorFlagContext> doorFlag() {
			return getRuleContexts(DoorFlagContext.class);
		}
		public DoorFlagContext doorFlag(int i) {
			return getRuleContext(DoorFlagContext.class,i);
		}
		public List<DigFlagContext> digFlag() {
			return getRuleContexts(DigFlagContext.class);
		}
		public DigFlagContext digFlag(int i) {
			return getRuleContext(DigFlagContext.class,i);
		}
		public List<NavigatorFlagContext> navigatorFlag() {
			return getRuleContexts(NavigatorFlagContext.class);
		}
		public NavigatorFlagContext navigatorFlag(int i) {
			return getRuleContext(NavigatorFlagContext.class,i);
		}
		public FlagSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flagSet; }
	}

	public final FlagSetContext flagSet() throws RecognitionException {
		FlagSetContext _localctx = new FlagSetContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_flagSet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(194);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case FLAG_TIMEOUT:
					{
					setState(188);
					timeoutFlag();
					}
					break;
				case FLAG_ANIMATE:
					{
					setState(189);
					animateFlag();
					}
					break;
				case FLAG_FLY:
					{
					setState(190);
					flyFlag();
					}
					break;
				case FLAG_DOOR:
					{
					setState(191);
					doorFlag();
					}
					break;
				case FLAG_DIG:
					{
					setState(192);
					digFlag();
					}
					break;
				case FLAG_NAVIGATOR:
					{
					setState(193);
					navigatorFlag();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(196); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8455716864L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TimeoutFlagContext extends ParserRuleContext {
		public Token timeout;
		public TerminalNode FLAG_TIMEOUT() { return getToken(JourneyParser.FLAG_TIMEOUT, 0); }
		public TerminalNode ID() { return getToken(JourneyParser.ID, 0); }
		public TimeoutFlagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeoutFlag; }
	}

	public final TimeoutFlagContext timeoutFlag() throws RecognitionException {
		TimeoutFlagContext _localctx = new TimeoutFlagContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_timeoutFlag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(FLAG_TIMEOUT);
			setState(199);
			((TimeoutFlagContext)_localctx).timeout = match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnimateFlagContext extends ParserRuleContext {
		public Token delay;
		public TerminalNode FLAG_ANIMATE() { return getToken(JourneyParser.FLAG_ANIMATE, 0); }
		public TerminalNode ID() { return getToken(JourneyParser.ID, 0); }
		public AnimateFlagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_animateFlag; }
	}

	public final AnimateFlagContext animateFlag() throws RecognitionException {
		AnimateFlagContext _localctx = new AnimateFlagContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_animateFlag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(FLAG_ANIMATE);
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(202);
				((AnimateFlagContext)_localctx).delay = match(ID);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FlyFlagContext extends ParserRuleContext {
		public TerminalNode FLAG_FLY() { return getToken(JourneyParser.FLAG_FLY, 0); }
		public TerminalNode TRUE() { return getToken(JourneyParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(JourneyParser.FALSE, 0); }
		public FlyFlagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flyFlag; }
	}

	public final FlyFlagContext flyFlag() throws RecognitionException {
		FlyFlagContext _localctx = new FlyFlagContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_flyFlag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(FLAG_FLY);
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FALSE || _la==TRUE) {
				{
				setState(206);
				_la = _input.LA(1);
				if ( !(_la==FALSE || _la==TRUE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DoorFlagContext extends ParserRuleContext {
		public TerminalNode FLAG_DOOR() { return getToken(JourneyParser.FLAG_DOOR, 0); }
		public TerminalNode TRUE() { return getToken(JourneyParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(JourneyParser.FALSE, 0); }
		public DoorFlagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doorFlag; }
	}

	public final DoorFlagContext doorFlag() throws RecognitionException {
		DoorFlagContext _localctx = new DoorFlagContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_doorFlag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(FLAG_DOOR);
			setState(211);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FALSE || _la==TRUE) {
				{
				setState(210);
				_la = _input.LA(1);
				if ( !(_la==FALSE || _la==TRUE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DigFlagContext extends ParserRuleContext {
		public TerminalNode FLAG_DIG() { return getToken(JourneyParser.FLAG_DIG, 0); }
		public TerminalNode TRUE() { return getToken(JourneyParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(JourneyParser.FALSE, 0); }
		public DigFlagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_digFlag; }
	}

	public final DigFlagContext digFlag() throws RecognitionException {
		DigFlagContext _localctx = new DigFlagContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_digFlag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(FLAG_DIG);
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FALSE || _la==TRUE) {
				{
				setState(214);
				_la = _input.LA(1);
				if ( !(_la==FALSE || _la==TRUE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NavigatorFlagContext extends ParserRuleContext {
		public IdentifierContext navigator;
		public IdentifierContext options;
		public TerminalNode FLAG_NAVIGATOR() { return getToken(JourneyParser.FLAG_NAVIGATOR, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode OPEN_BRACE() { return getToken(JourneyParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSED_BRACE() { return getToken(JourneyParser.CLOSED_BRACE, 0); }
		public NavigatorFlagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_navigatorFlag; }
	}

	public final NavigatorFlagContext navigatorFlag() throws RecognitionException {
		NavigatorFlagContext _localctx = new NavigatorFlagContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_navigatorFlag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(FLAG_NAVIGATOR);
			setState(218);
			((NavigatorFlagContext)_localctx).navigator = identifier();
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_BRACE) {
				{
				setState(219);
				match(OPEN_BRACE);
				setState(220);
				((NavigatorFlagContext)_localctx).options = identifier();
				setState(221);
				match(CLOSED_BRACE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public List<TerminalNode> SINGLE_QUOTE() { return getTokens(JourneyParser.SINGLE_QUOTE); }
		public TerminalNode SINGLE_QUOTE(int i) {
			return getToken(JourneyParser.SINGLE_QUOTE, i);
		}
		public List<TerminalNode> DOUBLE_QUOTE() { return getTokens(JourneyParser.DOUBLE_QUOTE); }
		public TerminalNode DOUBLE_QUOTE(int i) {
			return getToken(JourneyParser.DOUBLE_QUOTE, i);
		}
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_identifier);
		int _la;
		try {
			setState(242);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADMIN:
			case BUILD:
			case CACHE:
			case CANCEL:
			case CLEAR:
			case DEBUG:
			case FALSE:
			case INVALIDATE:
			case JOURNEY:
			case JOURNEY_TO:
			case LIST_NETHER_PORTALS:
			case LIST_WAYPOINTS:
			case PATH:
			case PLAYER:
			case PUBLIC:
			case RELOAD:
			case RENAME:
			case SERVER:
			case SET:
			case SET_WAYPOINT:
			case TRUE:
			case UNSET:
			case WAYPOINT:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(225);
				ident();
				}
				break;
			case SINGLE_QUOTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(226);
				match(SINGLE_QUOTE);
				setState(228); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(227);
					ident();
					}
					}
					setState(230); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 34493792190L) != 0) );
				setState(232);
				match(SINGLE_QUOTE);
				}
				break;
			case DOUBLE_QUOTE:
				enterOuterAlt(_localctx, 3);
				{
				setState(234);
				match(DOUBLE_QUOTE);
				setState(236); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(235);
					ident();
					}
					}
					setState(238); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 34493792190L) != 0) );
				setState(240);
				match(DOUBLE_QUOTE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(JourneyParser.ID, 0); }
		public TerminalNode ADMIN() { return getToken(JourneyParser.ADMIN, 0); }
		public TerminalNode BUILD() { return getToken(JourneyParser.BUILD, 0); }
		public TerminalNode CACHE() { return getToken(JourneyParser.CACHE, 0); }
		public TerminalNode CANCEL() { return getToken(JourneyParser.CANCEL, 0); }
		public TerminalNode CLEAR() { return getToken(JourneyParser.CLEAR, 0); }
		public TerminalNode DEBUG() { return getToken(JourneyParser.DEBUG, 0); }
		public TerminalNode FALSE() { return getToken(JourneyParser.FALSE, 0); }
		public TerminalNode INVALIDATE() { return getToken(JourneyParser.INVALIDATE, 0); }
		public TerminalNode JOURNEY() { return getToken(JourneyParser.JOURNEY, 0); }
		public TerminalNode JOURNEY_TO() { return getToken(JourneyParser.JOURNEY_TO, 0); }
		public TerminalNode LIST_NETHER_PORTALS() { return getToken(JourneyParser.LIST_NETHER_PORTALS, 0); }
		public TerminalNode LIST_WAYPOINTS() { return getToken(JourneyParser.LIST_WAYPOINTS, 0); }
		public TerminalNode PATH() { return getToken(JourneyParser.PATH, 0); }
		public TerminalNode PLAYER() { return getToken(JourneyParser.PLAYER, 0); }
		public TerminalNode PUBLIC() { return getToken(JourneyParser.PUBLIC, 0); }
		public TerminalNode RELOAD() { return getToken(JourneyParser.RELOAD, 0); }
		public TerminalNode RENAME() { return getToken(JourneyParser.RENAME, 0); }
		public TerminalNode SERVER() { return getToken(JourneyParser.SERVER, 0); }
		public TerminalNode SET() { return getToken(JourneyParser.SET, 0); }
		public TerminalNode SET_WAYPOINT() { return getToken(JourneyParser.SET_WAYPOINT, 0); }
		public TerminalNode TRUE() { return getToken(JourneyParser.TRUE, 0); }
		public TerminalNode UNSET() { return getToken(JourneyParser.UNSET, 0); }
		public TerminalNode WAYPOINT() { return getToken(JourneyParser.WAYPOINT, 0); }
		public IdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ident; }
	}

	public final IdentContext ident() throws RecognitionException {
		IdentContext _localctx = new IdentContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_ident);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 34493792190L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001&\u00f7\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0003\u0000O\b\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0003\u0001U\b\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0004\u0002[\b\u0002\u000b\u0002\f\u0002\\\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003b\b\u0003\u0001\u0004\u0003\u0004"+
		"e\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005j\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006r\b\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0003\t{\b\t\u0001\n\u0001\n\u0001\n\u0003\n\u0080\b\n\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0088\b\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0003\u000e\u008f\b\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0096"+
		"\b\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00a2"+
		"\b\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0003"+
		"\u0014\u00a9\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0003\u0016\u00b1\b\u0016\u0001\u0017\u0001\u0017\u0003"+
		"\u0017\u00b5\b\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0003"+
		"\u0019\u00bb\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0004\u001a\u00c3\b\u001a\u000b\u001a\f\u001a\u00c4"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0003\u001c"+
		"\u00cc\b\u001c\u0001\u001d\u0001\u001d\u0003\u001d\u00d0\b\u001d\u0001"+
		"\u001e\u0001\u001e\u0003\u001e\u00d4\b\u001e\u0001\u001f\u0001\u001f\u0003"+
		"\u001f\u00d8\b\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0003 "+
		"\u00e0\b \u0001!\u0001!\u0001!\u0004!\u00e5\b!\u000b!\f!\u00e6\u0001!"+
		"\u0001!\u0001!\u0001!\u0004!\u00ed\b!\u000b!\f!\u00ee\u0001!\u0001!\u0003"+
		"!\u00f3\b!\u0001\"\u0001\"\u0001\"\u0000\u0000#\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,."+
		"02468:<>@BD\u0000\u0002\u0002\u0000\b\b\u0018\u0018\u0005\u0000\u0001"+
		"\u0005\u0007\u000e\u0010\u0010\u0012\u001a##\u0101\u0000F\u0001\u0000"+
		"\u0000\u0000\u0002R\u0001\u0000\u0000\u0000\u0004X\u0001\u0000\u0000\u0000"+
		"\u0006^\u0001\u0000\u0000\u0000\bd\u0001\u0000\u0000\u0000\nf\u0001\u0000"+
		"\u0000\u0000\fk\u0001\u0000\u0000\u0000\u000es\u0001\u0000\u0000\u0000"+
		"\u0010u\u0001\u0000\u0000\u0000\u0012x\u0001\u0000\u0000\u0000\u0014|"+
		"\u0001\u0000\u0000\u0000\u0016\u0081\u0001\u0000\u0000\u0000\u0018\u0083"+
		"\u0001\u0000\u0000\u0000\u001a\u0089\u0001\u0000\u0000\u0000\u001c\u008c"+
		"\u0001\u0000\u0000\u0000\u001e\u0090\u0001\u0000\u0000\u0000 \u0097\u0001"+
		"\u0000\u0000\u0000\"\u0099\u0001\u0000\u0000\u0000$\u009c\u0001\u0000"+
		"\u0000\u0000&\u00a3\u0001\u0000\u0000\u0000(\u00a5\u0001\u0000\u0000\u0000"+
		"*\u00aa\u0001\u0000\u0000\u0000,\u00ad\u0001\u0000\u0000\u0000.\u00b2"+
		"\u0001\u0000\u0000\u00000\u00b6\u0001\u0000\u0000\u00002\u00b8\u0001\u0000"+
		"\u0000\u00004\u00c2\u0001\u0000\u0000\u00006\u00c6\u0001\u0000\u0000\u0000"+
		"8\u00c9\u0001\u0000\u0000\u0000:\u00cd\u0001\u0000\u0000\u0000<\u00d1"+
		"\u0001\u0000\u0000\u0000>\u00d5\u0001\u0000\u0000\u0000@\u00d9\u0001\u0000"+
		"\u0000\u0000B\u00f2\u0001\u0000\u0000\u0000D\u00f4\u0001\u0000\u0000\u0000"+
		"FN\u0005\n\u0000\u0000GO\u0003\u0004\u0002\u0000HO\u0003\u0006\u0003\u0000"+
		"IO\u0003\f\u0006\u0000JO\u0003\u0014\n\u0000KO\u0003\u0018\f\u0000LO\u0003"+
		"$\u0012\u0000MO\u00030\u0018\u0000NG\u0001\u0000\u0000\u0000NH\u0001\u0000"+
		"\u0000\u0000NI\u0001\u0000\u0000\u0000NJ\u0001\u0000\u0000\u0000NK\u0001"+
		"\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000NM\u0001\u0000\u0000\u0000"+
		"NO\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PQ\u0005\u0000\u0000"+
		"\u0001Q\u0001\u0001\u0000\u0000\u0000RT\u0005\u000b\u0000\u0000SU\u0003"+
		"2\u0019\u0000TS\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000UV\u0001"+
		"\u0000\u0000\u0000VW\u0005\u0000\u0000\u0001W\u0003\u0001\u0000\u0000"+
		"\u0000XZ\u0005\u0017\u0000\u0000Y[\u0003B!\u0000ZY\u0001\u0000\u0000\u0000"+
		"[\\\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000\\]\u0001\u0000"+
		"\u0000\u0000]\u0005\u0001\u0000\u0000\u0000^a\u0005\r\u0000\u0000_b\u0003"+
		"\b\u0004\u0000`b\u0003\n\u0005\u0000a_\u0001\u0000\u0000\u0000a`\u0001"+
		"\u0000\u0000\u0000b\u0007\u0001\u0000\u0000\u0000ce\u0005#\u0000\u0000"+
		"dc\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000e\t\u0001\u0000\u0000"+
		"\u0000fg\u0003\u0014\n\u0000gi\u0003B!\u0000hj\u0005#\u0000\u0000ih\u0001"+
		"\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000j\u000b\u0001\u0000\u0000"+
		"\u0000kl\u0005\u001a\u0000\u0000lq\u0003B!\u0000mr\u0003\u000e\u0007\u0000"+
		"nr\u0003\u0010\b\u0000or\u0003\u0012\t\u0000pr\u00034\u001a\u0000qm\u0001"+
		"\u0000\u0000\u0000qn\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000"+
		"qp\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000r\r\u0001\u0000\u0000"+
		"\u0000st\u0005\u0019\u0000\u0000t\u000f\u0001\u0000\u0000\u0000uv\u0005"+
		"\u0014\u0000\u0000vw\u0003B!\u0000w\u0011\u0001\u0000\u0000\u0000xz\u0005"+
		"\u0012\u0000\u0000y{\u0007\u0000\u0000\u0000zy\u0001\u0000\u0000\u0000"+
		"z{\u0001\u0000\u0000\u0000{\u0013\u0001\u0000\u0000\u0000|}\u0005\u0010"+
		"\u0000\u0000}\u007f\u0003B!\u0000~\u0080\u0003\u0016\u000b\u0000\u007f"+
		"~\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0015"+
		"\u0001\u0000\u0000\u0000\u0081\u0082\u0003B!\u0000\u0082\u0017\u0001\u0000"+
		"\u0000\u0000\u0083\u0087\u0005\u0015\u0000\u0000\u0084\u0088\u0003\u001a"+
		"\r\u0000\u0085\u0088\u0003\u001c\u000e\u0000\u0086\u0088\u0003\u001e\u000f"+
		"\u0000\u0087\u0084\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000"+
		"\u0000\u0087\u0086\u0001\u0000\u0000\u0000\u0088\u0019\u0001\u0000\u0000"+
		"\u0000\u0089\u008a\u0005\u0017\u0000\u0000\u008a\u008b\u0003B!\u0000\u008b"+
		"\u001b\u0001\u0000\u0000\u0000\u008c\u008e\u0005\r\u0000\u0000\u008d\u008f"+
		"\u0005#\u0000\u0000\u008e\u008d\u0001\u0000\u0000\u0000\u008e\u008f\u0001"+
		"\u0000\u0000\u0000\u008f\u001d\u0001\u0000\u0000\u0000\u0090\u0091\u0005"+
		"\u001a\u0000\u0000\u0091\u0095\u0003B!\u0000\u0092\u0096\u0003 \u0010"+
		"\u0000\u0093\u0096\u0003\"\u0011\u0000\u0094\u0096\u00034\u001a\u0000"+
		"\u0095\u0092\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000"+
		"\u0095\u0094\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000"+
		"\u0096\u001f\u0001\u0000\u0000\u0000\u0097\u0098\u0005\u0019\u0000\u0000"+
		"\u0098!\u0001\u0000\u0000\u0000\u0099\u009a\u0005\u0014\u0000\u0000\u009a"+
		"\u009b\u0003B!\u0000\u009b#\u0001\u0000\u0000\u0000\u009c\u00a1\u0005"+
		"\u0001\u0000\u0000\u009d\u00a2\u0003&\u0013\u0000\u009e\u00a2\u0003(\u0014"+
		"\u0000\u009f\u00a2\u0005\u0013\u0000\u0000\u00a0\u00a2\u0003.\u0017\u0000"+
		"\u00a1\u009d\u0001\u0000\u0000\u0000\u00a1\u009e\u0001\u0000\u0000\u0000"+
		"\u00a1\u009f\u0001\u0000\u0000\u0000\u00a1\u00a0\u0001\u0000\u0000\u0000"+
		"\u00a2%\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005\u0007\u0000\u0000\u00a4"+
		"\'\u0001\u0000\u0000\u0000\u00a5\u00a8\u0005\u0003\u0000\u0000\u00a6\u00a9"+
		"\u0003*\u0015\u0000\u00a7\u00a9\u0003,\u0016\u0000\u00a8\u00a6\u0001\u0000"+
		"\u0000\u0000\u00a8\u00a7\u0001\u0000\u0000\u0000\u00a9)\u0001\u0000\u0000"+
		"\u0000\u00aa\u00ab\u0005\u0011\u0000\u0000\u00ab\u00ac\u0005\u0005\u0000"+
		"\u0000\u00ac+\u0001\u0000\u0000\u0000\u00ad\u00b0\u0005\u000f\u0000\u0000"+
		"\u00ae\u00b1\u0005\u0005\u0000\u0000\u00af\u00b1\u0005\u0002\u0000\u0000"+
		"\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b0\u00af\u0001\u0000\u0000\u0000"+
		"\u00b1-\u0001\u0000\u0000\u0000\u00b2\u00b4\u0005\f\u0000\u0000\u00b3"+
		"\u00b5\u0005#\u0000\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b4\u00b5"+
		"\u0001\u0000\u0000\u0000\u00b5/\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005"+
		"\u0004\u0000\u0000\u00b71\u0001\u0000\u0000\u0000\u00b8\u00ba\u0003B!"+
		"\u0000\u00b9\u00bb\u00034\u001a\u0000\u00ba\u00b9\u0001\u0000\u0000\u0000"+
		"\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb3\u0001\u0000\u0000\u0000\u00bc"+
		"\u00c3\u00036\u001b\u0000\u00bd\u00c3\u00038\u001c\u0000\u00be\u00c3\u0003"+
		":\u001d\u0000\u00bf\u00c3\u0003<\u001e\u0000\u00c0\u00c3\u0003>\u001f"+
		"\u0000\u00c1\u00c3\u0003@ \u0000\u00c2\u00bc\u0001\u0000\u0000\u0000\u00c2"+
		"\u00bd\u0001\u0000\u0000\u0000\u00c2\u00be\u0001\u0000\u0000\u0000\u00c2"+
		"\u00bf\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c1\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c2\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5"+
		"5\u0001\u0000\u0000\u0000\u00c6\u00c7\u0005 \u0000\u0000\u00c7\u00c8\u0005"+
		"#\u0000\u0000\u00c87\u0001\u0000\u0000\u0000\u00c9\u00cb\u0005\u001b\u0000"+
		"\u0000\u00ca\u00cc\u0005#\u0000\u0000\u00cb\u00ca\u0001\u0000\u0000\u0000"+
		"\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc9\u0001\u0000\u0000\u0000\u00cd"+
		"\u00cf\u0005\u001e\u0000\u0000\u00ce\u00d0\u0007\u0000\u0000\u0000\u00cf"+
		"\u00ce\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0"+
		";\u0001\u0000\u0000\u0000\u00d1\u00d3\u0005\u001d\u0000\u0000\u00d2\u00d4"+
		"\u0007\u0000\u0000\u0000\u00d3\u00d2\u0001\u0000\u0000\u0000\u00d3\u00d4"+
		"\u0001\u0000\u0000\u0000\u00d4=\u0001\u0000\u0000\u0000\u00d5\u00d7\u0005"+
		"\u001c\u0000\u0000\u00d6\u00d8\u0007\u0000\u0000\u0000\u00d7\u00d6\u0001"+
		"\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8?\u0001\u0000"+
		"\u0000\u0000\u00d9\u00da\u0005\u001f\u0000\u0000\u00da\u00df\u0003B!\u0000"+
		"\u00db\u00dc\u0005!\u0000\u0000\u00dc\u00dd\u0003B!\u0000\u00dd\u00de"+
		"\u0005\"\u0000\u0000\u00de\u00e0\u0001\u0000\u0000\u0000\u00df\u00db\u0001"+
		"\u0000\u0000\u0000\u00df\u00e0\u0001\u0000\u0000\u0000\u00e0A\u0001\u0000"+
		"\u0000\u0000\u00e1\u00f3\u0003D\"\u0000\u00e2\u00e4\u0005$\u0000\u0000"+
		"\u00e3\u00e5\u0003D\"\u0000\u00e4\u00e3\u0001\u0000\u0000\u0000\u00e5"+
		"\u00e6\u0001\u0000\u0000\u0000\u00e6\u00e4\u0001\u0000\u0000\u0000\u00e6"+
		"\u00e7\u0001\u0000\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000\u00e8"+
		"\u00e9\u0005$\u0000\u0000\u00e9\u00f3\u0001\u0000\u0000\u0000\u00ea\u00ec"+
		"\u0005%\u0000\u0000\u00eb\u00ed\u0003D\"\u0000\u00ec\u00eb\u0001\u0000"+
		"\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000"+
		"\u0000\u0000\u00ee\u00ef\u0001\u0000\u0000\u0000\u00ef\u00f0\u0001\u0000"+
		"\u0000\u0000\u00f0\u00f1\u0005%\u0000\u0000\u00f1\u00f3\u0001\u0000\u0000"+
		"\u0000\u00f2\u00e1\u0001\u0000\u0000\u0000\u00f2\u00e2\u0001\u0000\u0000"+
		"\u0000\u00f2\u00ea\u0001\u0000\u0000\u0000\u00f3C\u0001\u0000\u0000\u0000"+
		"\u00f4\u00f5\u0007\u0001\u0000\u0000\u00f5E\u0001\u0000\u0000\u0000\u001b"+
		"NT\\adiqz\u007f\u0087\u008e\u0095\u00a1\u00a8\u00b0\u00b4\u00ba\u00c2"+
		"\u00c4\u00cb\u00cf\u00d3\u00d7\u00df\u00e6\u00ee\u00f2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}