// Generated from c:/Projects/journey/command/src/main/antlr/net/whimxiqal/journey/command/Journey.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JourneyParser}.
 */
public interface JourneyListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JourneyParser#journey}.
	 * @param ctx the parse tree
	 */
	void enterJourney(JourneyParser.JourneyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#journey}.
	 * @param ctx the parse tree
	 */
	void exitJourney(JourneyParser.JourneyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#journeyto}.
	 * @param ctx the parse tree
	 */
	void enterJourneyto(JourneyParser.JourneytoContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#journeyto}.
	 * @param ctx the parse tree
	 */
	void exitJourneyto(JourneyParser.JourneytoContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#setwaypoint}.
	 * @param ctx the parse tree
	 */
	void enterSetwaypoint(JourneyParser.SetwaypointContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#setwaypoint}.
	 * @param ctx the parse tree
	 */
	void exitSetwaypoint(JourneyParser.SetwaypointContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#listwaypoints}.
	 * @param ctx the parse tree
	 */
	void enterListwaypoints(JourneyParser.ListwaypointsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#listwaypoints}.
	 * @param ctx the parse tree
	 */
	void exitListwaypoints(JourneyParser.ListwaypointsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#listwaypointsMine}.
	 * @param ctx the parse tree
	 */
	void enterListwaypointsMine(JourneyParser.ListwaypointsMineContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#listwaypointsMine}.
	 * @param ctx the parse tree
	 */
	void exitListwaypointsMine(JourneyParser.ListwaypointsMineContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#listwaypointsPlayer}.
	 * @param ctx the parse tree
	 */
	void enterListwaypointsPlayer(JourneyParser.ListwaypointsPlayerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#listwaypointsPlayer}.
	 * @param ctx the parse tree
	 */
	void exitListwaypointsPlayer(JourneyParser.ListwaypointsPlayerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#waypoint}.
	 * @param ctx the parse tree
	 */
	void enterWaypoint(JourneyParser.WaypointContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#waypoint}.
	 * @param ctx the parse tree
	 */
	void exitWaypoint(JourneyParser.WaypointContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#unsetWaypoint}.
	 * @param ctx the parse tree
	 */
	void enterUnsetWaypoint(JourneyParser.UnsetWaypointContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#unsetWaypoint}.
	 * @param ctx the parse tree
	 */
	void exitUnsetWaypoint(JourneyParser.UnsetWaypointContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#renameWaypoint}.
	 * @param ctx the parse tree
	 */
	void enterRenameWaypoint(JourneyParser.RenameWaypointContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#renameWaypoint}.
	 * @param ctx the parse tree
	 */
	void exitRenameWaypoint(JourneyParser.RenameWaypointContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#publicWaypoint}.
	 * @param ctx the parse tree
	 */
	void enterPublicWaypoint(JourneyParser.PublicWaypointContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#publicWaypoint}.
	 * @param ctx the parse tree
	 */
	void exitPublicWaypoint(JourneyParser.PublicWaypointContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#player}.
	 * @param ctx the parse tree
	 */
	void enterPlayer(JourneyParser.PlayerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#player}.
	 * @param ctx the parse tree
	 */
	void exitPlayer(JourneyParser.PlayerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#playerWaypoint}.
	 * @param ctx the parse tree
	 */
	void enterPlayerWaypoint(JourneyParser.PlayerWaypointContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#playerWaypoint}.
	 * @param ctx the parse tree
	 */
	void exitPlayerWaypoint(JourneyParser.PlayerWaypointContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#server}.
	 * @param ctx the parse tree
	 */
	void enterServer(JourneyParser.ServerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#server}.
	 * @param ctx the parse tree
	 */
	void exitServer(JourneyParser.ServerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#serverSetWaypoint}.
	 * @param ctx the parse tree
	 */
	void enterServerSetWaypoint(JourneyParser.ServerSetWaypointContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#serverSetWaypoint}.
	 * @param ctx the parse tree
	 */
	void exitServerSetWaypoint(JourneyParser.ServerSetWaypointContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#serverListWaypoints}.
	 * @param ctx the parse tree
	 */
	void enterServerListWaypoints(JourneyParser.ServerListWaypointsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#serverListWaypoints}.
	 * @param ctx the parse tree
	 */
	void exitServerListWaypoints(JourneyParser.ServerListWaypointsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#serverWaypoint}.
	 * @param ctx the parse tree
	 */
	void enterServerWaypoint(JourneyParser.ServerWaypointContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#serverWaypoint}.
	 * @param ctx the parse tree
	 */
	void exitServerWaypoint(JourneyParser.ServerWaypointContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#serverUnsetWaypoint}.
	 * @param ctx the parse tree
	 */
	void enterServerUnsetWaypoint(JourneyParser.ServerUnsetWaypointContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#serverUnsetWaypoint}.
	 * @param ctx the parse tree
	 */
	void exitServerUnsetWaypoint(JourneyParser.ServerUnsetWaypointContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#serverRenameWaypoint}.
	 * @param ctx the parse tree
	 */
	void enterServerRenameWaypoint(JourneyParser.ServerRenameWaypointContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#serverRenameWaypoint}.
	 * @param ctx the parse tree
	 */
	void exitServerRenameWaypoint(JourneyParser.ServerRenameWaypointContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#admin}.
	 * @param ctx the parse tree
	 */
	void enterAdmin(JourneyParser.AdminContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#admin}.
	 * @param ctx the parse tree
	 */
	void exitAdmin(JourneyParser.AdminContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#debug}.
	 * @param ctx the parse tree
	 */
	void enterDebug(JourneyParser.DebugContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#debug}.
	 * @param ctx the parse tree
	 */
	void exitDebug(JourneyParser.DebugContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#cache}.
	 * @param ctx the parse tree
	 */
	void enterCache(JourneyParser.CacheContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#cache}.
	 * @param ctx the parse tree
	 */
	void exitCache(JourneyParser.CacheContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#cachePortals}.
	 * @param ctx the parse tree
	 */
	void enterCachePortals(JourneyParser.CachePortalsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#cachePortals}.
	 * @param ctx the parse tree
	 */
	void exitCachePortals(JourneyParser.CachePortalsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#cachePaths}.
	 * @param ctx the parse tree
	 */
	void enterCachePaths(JourneyParser.CachePathsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#cachePaths}.
	 * @param ctx the parse tree
	 */
	void exitCachePaths(JourneyParser.CachePathsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#listNetherPortals}.
	 * @param ctx the parse tree
	 */
	void enterListNetherPortals(JourneyParser.ListNetherPortalsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#listNetherPortals}.
	 * @param ctx the parse tree
	 */
	void exitListNetherPortals(JourneyParser.ListNetherPortalsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#cancel}.
	 * @param ctx the parse tree
	 */
	void enterCancel(JourneyParser.CancelContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#cancel}.
	 * @param ctx the parse tree
	 */
	void exitCancel(JourneyParser.CancelContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#journeytoTarget}.
	 * @param ctx the parse tree
	 */
	void enterJourneytoTarget(JourneyParser.JourneytoTargetContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#journeytoTarget}.
	 * @param ctx the parse tree
	 */
	void exitJourneytoTarget(JourneyParser.JourneytoTargetContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#flagSet}.
	 * @param ctx the parse tree
	 */
	void enterFlagSet(JourneyParser.FlagSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#flagSet}.
	 * @param ctx the parse tree
	 */
	void exitFlagSet(JourneyParser.FlagSetContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#timeoutFlag}.
	 * @param ctx the parse tree
	 */
	void enterTimeoutFlag(JourneyParser.TimeoutFlagContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#timeoutFlag}.
	 * @param ctx the parse tree
	 */
	void exitTimeoutFlag(JourneyParser.TimeoutFlagContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#animateFlag}.
	 * @param ctx the parse tree
	 */
	void enterAnimateFlag(JourneyParser.AnimateFlagContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#animateFlag}.
	 * @param ctx the parse tree
	 */
	void exitAnimateFlag(JourneyParser.AnimateFlagContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#flyFlag}.
	 * @param ctx the parse tree
	 */
	void enterFlyFlag(JourneyParser.FlyFlagContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#flyFlag}.
	 * @param ctx the parse tree
	 */
	void exitFlyFlag(JourneyParser.FlyFlagContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#doorFlag}.
	 * @param ctx the parse tree
	 */
	void enterDoorFlag(JourneyParser.DoorFlagContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#doorFlag}.
	 * @param ctx the parse tree
	 */
	void exitDoorFlag(JourneyParser.DoorFlagContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#digFlag}.
	 * @param ctx the parse tree
	 */
	void enterDigFlag(JourneyParser.DigFlagContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#digFlag}.
	 * @param ctx the parse tree
	 */
	void exitDigFlag(JourneyParser.DigFlagContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#navigatorFlag}.
	 * @param ctx the parse tree
	 */
	void enterNavigatorFlag(JourneyParser.NavigatorFlagContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#navigatorFlag}.
	 * @param ctx the parse tree
	 */
	void exitNavigatorFlag(JourneyParser.NavigatorFlagContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(JourneyParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(JourneyParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JourneyParser#ident}.
	 * @param ctx the parse tree
	 */
	void enterIdent(JourneyParser.IdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JourneyParser#ident}.
	 * @param ctx the parse tree
	 */
	void exitIdent(JourneyParser.IdentContext ctx);
}